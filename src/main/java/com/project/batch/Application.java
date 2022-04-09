package com.project.batch;

import com.project.batch.config.SpringBatchConfig;
import com.project.batch.config.SpringConfig;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class Application {

//	@Autowired
//	JobLauncher jobLauncher;

//	@Autowired
//	@Qualifier("firstBatchJob")
//	Job job;

    public static void main(String[] args) {

//		SpringApplication.run(Application.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(SpringConfig.class);
		context.register(SpringBatchConfig.class);
		context.refresh();

		JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("firstBatchJob");
		System.out.println("Starting the batch job");
		try {
			JobExecution execution = launcher.run(job, new JobParameters());
			System.out.println("Job status: "+execution.getStatus());
			System.out.println("Job Completed");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Job failed");
		}
    }

//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		System.out.println("Starting the batch job");
//		try {
//			JobExecution execution = jobLauncher.run(job, new JobParameters());
//			System.out.println("Job Status : " + execution.getStatus());
//			System.out.println("Job completed");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Job failed");
//		}
//	}
}
