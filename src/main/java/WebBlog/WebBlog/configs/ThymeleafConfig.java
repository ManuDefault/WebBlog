//package WebBlog.WebBlog.configs;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring6.view.ThymeleafViewResolver;
//import org.thymeleaf.templatemode.TemplateMode;
//
//@Configuration
//public class ThymeleafConfig {
//
//    private static final String UTF8 = "UTF-8";
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Bean
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//        resolver.setApplicationContext(applicationContext);
//        resolver.setPrefix("classpath:/templates/");
//        resolver.setSuffix(".html");
//        resolver.setCharacterEncoding(UTF8);
//        resolver.setTemplateMode(TemplateMode.HTML);
//        resolver.setCacheable(false); // В режиме разработки лучше отключить кэширование шаблонов
//        return resolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine engine = new SpringTemplateEngine();
//        engine.setTemplateResolver(templateResolver());
//        return engine;
//    }
//
//    @Bean
//    public ThymeleafViewResolver thymeleafViewResolver() {
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine(templateEngine());
//        resolver.setCharacterEncoding(UTF8);
//        return resolver;
//    }
//}
