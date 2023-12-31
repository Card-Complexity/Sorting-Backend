package com.nighthawk.spring_portfolio;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    // set up your own index
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    /*
     * map path and location for "uploads" outside of application resources
     * ... creates a directory outside "static" folder, "file:volumes/uploads"
     * ... CRITICAL, without this uploaded file will not be loaded/displayed by
     * frontend
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/volumes/uploads/**").addResourceLocations("file:volumes/uploads/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/sorts/bubble")
                .allowedOrigins("http://127.0.0.1:5500",
                        "https://card-complexity.github.io/Card-Visualization-Frontend", "http://localhost:8085",
                        "http://127.0.0.1:4100/Card-Visualization-Frontend/")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");

        registry.addMapping("/api/sorts/selection")
                .allowedOrigins("http://127.0.0.1:5500",
                        "https://card-complexity.github.io/Card-Visualization-Frontend", "http://localhost:8085",
                        "http://127.0.0.1:4100/Card-Visualization-Frontend/")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");

        registry.addMapping("/api/sorts/merge")
                .allowedOrigins("http://127.0.0.1:5500",
                        "https://card-complexity.github.io/Card-Visualization-Frontend", "http://localhost:8085",
                        "http://127.0.0.1:4100/Card-Visualization-Frontend/")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");

        registry.addMapping("/api/sorts/insertion")
                .allowedOrigins("http://127.0.0.1:5500",
                        "https://card-complexity.github.io/Card-Visualization-Frontend", "http://localhost:8085",
                        "http://127.0.0.1:4100/Card-Visualization-Frontend/")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");

        registry.addMapping("/api/sorts/bubbleCards")
                .allowedOrigins("http://127.0.0.1:5500",
                        "https://card-complexity.github.io/Card-Visualization-Frontend", "http://localhost:8085",
                        "http://127.0.0.1:4100/Card-Visualization-Frontend/")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");

        registry.addMapping("/api/sorts/selectionCards")
                .allowedOrigins("http://127.0.0.1:5500",
                        "https://card-complexity.github.io/Card-Visualization-Frontend", "http://localhost:8085",
                        "http://127.0.0.1:4100/Card-Visualization-Frontend/")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");

        registry.addMapping("/api/sorts/mergeCards")
                .allowedOrigins("http://127.0.0.1:5500",
                        "https://card-complexity.github.io/Card-Visualization-Frontend", "http://localhost:8085",
                        "http://127.0.0.1:4100/Card-Visualization-Frontend/")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");

        registry.addMapping("/api/sorts/insertionCards")
                .allowedOrigins("http://127.0.0.1:5500",
                        "https://card-complexity.github.io/Card-Visualization-Frontend", "http://localhost:8085",
                        "http://127.0.0.1:4100/Card-Visualization-Frontend/")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");

        registry.addMapping("/api/sorts/fibonacci")
                .allowedOrigins("http://127.0.0.1:5500",
                        "https://card-complexity.github.io/Card-Visualization-Frontend", "http://localhost:8085",
                        "http://127.0.0.1:4100/Card-Visualization-Frontend/")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");

        registry.addMapping("/api/sorts/palindrome")
                .allowedOrigins("http://127.0.0.1:5500",
                        "https://card-complexity.github.io/Card-Visualization-Frontend", "http://localhost:8085",
                        "http://127.0.0.1:4100/Card-Visualization-Frontend/")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }

}
