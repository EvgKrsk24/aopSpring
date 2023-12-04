package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(20)
public class SecurityAspect {
    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddSecuritygAdvice() {
        System.out.println("beforeGetSecuritygAdvice: проверка прав на получениие" +
                " книги/журнала");
        System.out.println("------------------------------------------");
    }

}
