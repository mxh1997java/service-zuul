package www.maxinhai.com.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    /**
     * 功能描述: 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型
     *             pre：可以在请求被路由之前调用
     *             routing：在路由请求时候被调用
     *             post：在routing和error过滤器之后被调用
     *             error：处理请求时发生错误时被调用
     * @Return: java.lang.String
     * @Author: 15735400536
     * @Date: 2020/7/22 21:03
     */
    @Override
    public String filterType() {
        return null;
    }

    /**
     * 功能描述: 通过int值来定义过滤器的执行顺序
     * @Return: int
     * @Author: 15735400536
     * @Date: 2020/7/22 21:02
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 功能描述: 返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关
     * @Return: boolean
     * @Author: 15735400536
     * @Date: 2020/7/22 21:02
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /**
     * 功能描述: 过滤器具体逻辑
     * @Return: java.lang.Object
     * @Author: 15735400536
     * @Date: 2020/7/22 21:01
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
    }
}
