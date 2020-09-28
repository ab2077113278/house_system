package cn.sx.utils;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: house_System
 * Author sx
 * @desc 请求过滤器
 * @create: 2020-08-07 11:05
 **/
@WebFilter(filterName = "customizeEncodingFilter")
public class CustomizeEncodingFilter implements Filter {
    //编码格式
    private String encoding = null;
    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        if (encoding == null) {
            encoding = "UTF-8";
        }

//        System.out.println("设置了请求的编码   " + encoding);
        // 设置请求的编码
        req.setCharacterEncoding(encoding);

        // 设置应答对象的内容类型（包括编码格式）
//        res.setCharacterEncoding(encoding);
//        res.setContentType("text/html;charset=utf-8");

        // 传递给下一个过滤器
        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
        this.encoding = null;
    }
}
