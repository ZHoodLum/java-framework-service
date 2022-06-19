package basal;

import java.util.Calendar;
import java.util.Date;

class getDateTime {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int i = calendar.get(Calendar.DAY_OF_WEEK - 1);
        i = i == 0 ? 7 : i;

        int dataOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println(dataOfMonth);


    }
}