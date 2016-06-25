package com.controller

import com.model.WeiboModel
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import com.services.WeiboAPI
import com.custom.exception.AppRuntimeException
import com.custom.exception.PaginationException

/**
 *  This is the demo for X Plus Z Code Exercise
 *  Requirement
 *  Create a spring boot project to get latest public weibo of sina weibo.
 *  Implement Requirement:
 * ·    Try to write you own REST Client with groovy, try NOT to use Sina SDK, we don't accept JS version.
 * ·    Use Bootstrap
 * ·    Add pagination, default page size is 10
 * ·    Create a public repository in Github and commit you codes
 * ·    Deploy you app to Docker
 * ·    Upload you docker image to DockerHub
 * @authur rxu<xurui8611@126.com>
 */
@ComponentScan
@RestController
@RequestMapping("/")
class PaginationController {

    final Logger LOG = Logger.getLogger(this.class);
    final Timer timer = new Timer()
    def entities = new LinkedList<WeiboModel>()
    @Autowired
    @Qualifier("weiboApi")
    private WeiboAPI weiboApi;

    def getNumberPerPage() {
        return numberPerPage
    }

    /**
     * redirect the url to welcome page
     * @return return ModelAndView {@link ModelAndView} for ui view
     */
    @RequestMapping("/")
    ModelAndView initialize() {
        LOG.info("initialize the weibo infomation.");
        entities = getPublicWeibo()
        totalWeibos = entities.size()
        def Map<String,Object> model = new HashMap<String,Object>();
        model.put("entities",entities.subList(0,numberPerPage));
        model.put("totalWeibos",totalWeibos);
        model.put("pages",totalWeibos.intdiv(numberPerPage) + 1 );
        return new ModelAndView("welcome",model);
    }

    void setNumberPerPage(numberPerPage) {
        this.numberPerPage = numberPerPage
    }
    def numberPerPage = 10 //default value

    def totalWeibos = 200 //default value

    public PaginationController() {
        TimerTask task = new TimerTask() {
            @Override
            void run() {
                init()
            }
        }
        timer.schedule(task, 3000)
    }

    private void init() {
        LOG.info("initialize .......");
        /// entities = getPublicWeibo()
        // totalWeibos = entities.size()
    }

    private getPublicWeibo(){

        return weiboApi.getPublicTimeline()
    }

    /**
     * This method {@link com.controller.PaginationController#doPagination}
     * is used to do pagination by asynchronized pattern through ajax request from
     * js function.
     * @param pageNum page num which will be displayed on the ui
     * @return return ModelAndView {@link ModelAndView} for ui view
     */
    @RequestMapping(value = "/weibo/{pageId}", method=RequestMethod.POST)
    @ResponseBody
    public ModelAndView doPagination(@PathVariable("pageId") Integer pageNum) {
        LOG.info("Do pagination.");
        LOG.debug("Change the page num to ".concat(String.valueOf(pageNum)));
        if(pageNum == null){
            LOG.error("Page num can not be null.");
            throw new PaginationException("Page num can not be null.");
        }
        try{
            def fromIndex = pageNum != 1 ?(pageNum - 1).multiply(numberPerPage)  : 0;
            def endIndex = fromIndex + numberPerPage ;
            if(endIndex > entities.size()){
                endIndex = entities.size() - 1;
            }
            ModelAndView modelAndView = new ModelAndView("list","entities",entities.subList(fromIndex ,endIndex));
            modelAndView.setViewName("Page");
            return modelAndView;
        }catch (Exception ex){
            LOG.error(ex.message);
            throw new PaginationException("Do pagination failed.");
        }

    }

    /**
     * handle app runtime exception
     * @param ex Customized exception {@link AppRuntimeException}
     * @return return ModelAndView {@link ModelAndView} to path "Error.jsp"
     */
    @ExceptionHandler
    ModelAndView handle(AppRuntimeException ex) {
        ModelAndView model = new ModelAndView("Error");
        model.addObject("errMsg", ex.message);
        return model;
    }

}
