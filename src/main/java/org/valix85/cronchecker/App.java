package org.valix85.cronchecker;

import org.quartz.CronExpression;

import java.text.ParseException;

/**
 * Per creare il jar utitlizzare il pannello maven e da Lifecycle selezionare package
 * per utilizzare il toolda cli fare
 * java -jar cronChecker "0 30 5 ? * *"
 * */


public class App {

    public static void main(String[] args) {

        System.out.println("Per controllare una cron expression da riga di comando è necessario passare come argomento la stessa racchiusa tra doppi apici");
        System.out.println("Ex: $ java -jar cronChecker \"0 0 12 ? * WED\" ");
        System.out.println("\n");
        String cronExpression = "";
        if (args.length>0){
            cronExpression = args[0];
        }else{
            cronExpression = "0 30 5 ? * *";
        }
        System.out.println("Test expression: "+cronExpression);
        try {
            CronExpression cron = new CronExpression(cronExpression);
            System.out.println("Expression OK for: \""+cronExpression+"\"");

            System.out.println("exit code: 0");
            System.exit(0);
        } catch (ParseException e) {
            //exception handling
            System.out.println("Expression ERROR");
            System.out.println("http://www.quartz-scheduler.org/documentation/quartz-2.2.2/tutorials/tutorial-lesson-06.html");
            System.out.println("Params order: ");
            System.out.println("\t1 Seconds");
            System.out.println("\t2 Minutes");
            System.out.println("\t3 Hours");
            System.out.println("\t4 Day-of-Month");
            System.out.println("\t5 Month");
            System.out.println("\t6 Day-of-Week");
            System.out.println("\t7 Year (optional field)");
            e.printStackTrace();
            System.out.println("exit code: 400");
            System.exit(400);
        }
    }
}
