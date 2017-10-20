package ch.hsr.mge.gadgeothek.domain;


import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class LoanTest {

    private Loan loan;

    @Test
    public void overDueDateShouldBeOneWeekLater() {
        // Arrange
        loan = new Loan("someId", new Gadget("testGadget"), createDate(2017,10,21,0,0,0), null);

        // Act
        Date actualOverDueDate = loan.overDueDate();

        // Assert
        Assert.assertThat(actualOverDueDate, Is.is(createDate(2017, 10, 28, 0, 0, 0)));
    }





    private  Date createDate(int year, int month, int day, int hour,
                             int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);

        // Be careful: Month starts with 0
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();

    }
}
