package sortingClean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Enumeration;
import java.util.HashMap;

@Aspect
public class  Loggin {
   HashMap<String,DataInfo> dataMap=new HashMap<>();

    @Pointcut("execution(* *.sort(..))")
    private void loggingProcedure(){}

    @Pointcut("execution(void sortingClean.AlgorithmRunner.runAlgorithms())")
    private void aftersort(){}

    @Around("loggingProcedure()")
    public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
        String name = pjp.getSignature().getDeclaringType().getSimpleName();
        if(!dataMap.containsKey(name))
            dataMap.put(name,new DataInfo(name));
        DataInfo data=dataMap.get(name);
        data.start();
        pjp.proceed(pjp.getArgs());
        data.endRun();

    }

    @After("aftersort()")
    public void afterSortin(){
        Long alltime=dataMap.values().stream().mapToLong(DataInfo::getSumAllTime).sum();
        System.out.println("Total time of running all sort functions was " + alltime+" ms\nIn detail:");

        for (DataInfo item : dataMap.values()){
            System.out.println("Function sort in "+item.getName()+" ran "+item.getSumRead()+
                    " times and took in total "+item.getSumAllTime()+" ms");
        }
    }


}
