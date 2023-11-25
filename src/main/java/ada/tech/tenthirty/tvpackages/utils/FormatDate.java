package ada.tech.tenthirty.tvpackages.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDate {
  public static String dayMothYears(){
    LocalDateTime createDate = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return createDate.format(format);
  }
}
