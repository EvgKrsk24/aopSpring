package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Order(10) //порядок вып аспектов
public class LoggingAspect {

//  @Pointcut("execution(* aop.UniLibrary.*(..))")
//    private void allMethodsFromUnilibrary() {
//
//  }
//
//  @Pointcut("execution(public void aop.UniLibrary.returnMagazin())")
//    private void returnMagazineFromUnilibrary() {
//
//  }
//
//    @Pointcut("allMethodsFromUnilibrary() && !returnMagazineFromUnilibrary()")
//    private void allMethodsExceptReturnMagazinFromUnilibrary() {
//
//    }
//
//    @Before("allMethodsExceptReturnMagazinFromUnilibrary()")
//    public void beforeallMethodsExceptReturnMagazinAdvice() {
//        System.out.println("beforeallMethodsExceptReturnMagazinAdvice: writing Log #10");
//    }


//    @Pointcut("execution(* aop.UniLibrary.get*())")
//    private void allGetMethoodsFromUnilibrary() {
//    }
//
//    @Pointcut("execution(* aop.UniLibrary.return*())")
//    private void allReturnMethoodsFromUnilibrary() {
//    }
//
//    @Pointcut("allGetMethoodsFromUnilibrary() || allReturnMethoodsFromUnilibrary()")
//    private void allGetAndReturnMethoodsFromUnilibrary() {
//
//    }
//
//
//    @Before("allGetMethoodsFromUnilibrary()")
//    public void beforeGetLogginAdvice() {
//        System.out.println("beforeGetLogginAdvice: writing Log #1");
//    }
//
//    @Before("allReturnMethoodsFromUnilibrary()")
//    public void beforeReturnLogginAdvice() {
//        System.out.println("beforeReturnLogginAdvice: writing Log #2");
//    }
//
//    @Before("allGetAndReturnMethoodsFromUnilibrary()")
//    public void beforeGetAndReturnMethoodsFromUnilibrary() {
//        System.out.println("beforeReturnLogginAdvice: writing Log #3");
//    }



    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = "
                + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = "
                + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = "
                + methodSignature.getName());

        if(methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            for(Object obj:arguments) {
                if(obj instanceof Book) {
                    Book myBook=(Book) obj;
                    System.out.println("Информация о книге: название - " +
                            myBook.getName() + ", автор - " + myBook.getAuthor() +
                    " , год издания - " + myBook.getYearOfPublication());
                }
                else if(obj instanceof String) {
                    System.out.println("книгу в библиотеку добавляет " + obj);
                }

            }
        }




        System.out.println("beforeGetLoggingAdvice: логирование " +  "попытки получить книгу/журнал");
        System.out.println("------------------------------------------");
    }


}
