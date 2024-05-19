package br.com.exemplo.utils;

import br.com.exemplo.utils.enums.DateFormatUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class DateUtils {

    private static final Random random = new Random();

    public static String getDate(DateFormatUtils pattern, boolean isUTC){
        TimeZone tz = TimeZone.getTimeZone(isUTC? ZoneId.of("UTC") : ZoneId.systemDefault());
        DateFormat df = new SimpleDateFormat(pattern.toString());
        df.setTimeZone(tz);
        return df.format(new Date());
    }

    public static String getDate(DateFormatUtils pattern){
        TimeZone tz = TimeZone.getTimeZone(ZoneId.systemDefault());
        DateFormat df = new SimpleDateFormat(pattern.toString());
        df.setTimeZone(tz);
        return df.format(new Date());
    }

    public static String getDate(boolean isPast, DateFormatUtils pattern){
        TimeZone tz = TimeZone.getTimeZone(ZoneId.systemDefault());
        DateFormat df = new SimpleDateFormat(pattern.toString());
        df.setTimeZone(tz);
        return df.format(new Date(isPast?  System.currentTimeMillis() - (configurarTempoAleatorio(2)): System.currentTimeMillis() + configurarTempoAleatorio(2)));
    }

    public static String getDate(boolean isPast, DateFormatUtils pattern, boolean isUTC){
        TimeZone tz = TimeZone.getTimeZone(isUTC? ZoneId.of("UTC") : ZoneId.systemDefault());
        DateFormat df = new SimpleDateFormat(pattern.toString());
        df.setTimeZone(tz);
        return df.format(new Date(isPast? System.currentTimeMillis() - configurarTempoAleatorio(2): System.currentTimeMillis() + configurarTempoAleatorio(2)));
    }

    private static long configurarTempoAleatorio(double anosMaximos){
        return (long) (random.nextFloat() * (31557600000L * anosMaximos));
    }

    public static String gerarDataNascimento(DateFormatUtils pattern, int idadeMaxima, int idadeMinima){
        TimeZone tz = TimeZone.getTimeZone(ZoneId.systemDefault());
        DateFormat df = new SimpleDateFormat(pattern.toString());
        df.setTimeZone(tz);
        return df.format(new Date(System.currentTimeMillis() - quantidadeAnosEmMS(idadeMinima) - configurarTempoAleatorio(idadeMaxima-idadeMinima)));
    }

    private static long quantidadeAnosEmMS(int anos){
        return anos * 31536000000L;
    }

}
