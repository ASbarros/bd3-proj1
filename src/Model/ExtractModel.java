package Model;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExtractModel {

    int id;
    String description;
    double value;
    int type;
    AccountModel account;
    Calendar date = Calendar.getInstance();
    int DATA_BD = 0;

    public Calendar getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date.setTime(date);
    }

    public void setDateString(String sdate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date newDate = dateFormat.parse(sdate);

            this.date.setTime(newDate);
        } catch (ParseException e) {
            System.out.println("Erro ao converter a data: " + e.getMessage());
        }
    }

    public String getDateString(int iFormat) {
        Date dateCalendar = this.date.getTime();

        SimpleDateFormat dateFormat;
        if (iFormat == DATA_BD) {
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        } else {
            dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        }

        return dateFormat.format(dateCalendar);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }

    public static void parseExtract(ExtractModel obj, String data[]) {
        if (data[0].trim().equals("")) {
            obj.setId(0);
        } else {
            obj.setId(Integer.parseInt(data[0]));
        }
        obj.setDescription(data[1]);
        obj.setValue(Double.parseDouble(data[2]));
        obj.setType(Integer.parseInt(data[4]));
        obj.setDateString(data[5]);
    }

    public static ExtractModel parseExtract(String data[]) {
        ExtractModel extract = new ExtractModel();
        parseExtract(extract, data);

        return extract;
    }

    public String[] toArray() {
        String array[] = new String[6];
        array[0] = String.valueOf(this.getId());
        array[1] = this.getDescription();
        array[2] = String.valueOf(this.getValue());
        array[3] = String.valueOf(this.getType());
        //array[4] = this.getDateString(DATA_BRASIL);
        array[5] = String.valueOf(this.getAccount().getId());
        return array;
    }

}
