package org.jboss.arquillian.performance.junit;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.performance.HardWorker;
import org.jboss.arquillian.performance.annotation.Performance;
import org.jboss.arquillian.performance.annotation.PerformanceTest;
import org.jboss.arquillian.performance.exception.PerformanceException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@PerformanceTest(resultsThreshold=1.5)
@RunWith(Arquillian.class)
public class WorkHardTestCase
{

   @Test
   public void doHardWork() throws Exception 
   {
      HardWorker worker = new HardWorker();
      Assert.assertEquals(21, worker.workingHard(), 0d);
   }
   
   /**
    * This method is supposed to fail with @Performance(time=9)
    * 
    * @throws Exception
    */
   @Test(expected = PerformanceException.class)
   @Performance(time=5)
   public void doHardWorkThatFails() throws Exception
   {
      HardWorker worker = new HardWorker();
      Assert.assertEquals(21, worker.workingHard(), 0d);
   }
}
