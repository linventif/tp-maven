package fr.but3;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequestWrapper;

@WebFilter("/private/*")
public class MyXSSFilter extends jakarta.servlet.http.HttpFilter {
    public void doFilter(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse res, jakarta.servlet.FilterChain chain)
            throws java.io.IOException, jakarta.servlet.ServletException {
        jakarta.servlet.http.HttpServletRequest wrappedRequest = new HttpServletRequestWrapper(req) {
            @Override
            public String getParameter(String name) {
                String value = super.getParameter(name);
                if (value != null) {
                    value = value.replaceAll("<", "&lt;")
                            .replaceAll(">", "&gt;")
                            .replaceAll("(?i)script", "");
                }
                return value;
            }
        };
        chain.doFilter(wrappedRequest, res);
    }
}