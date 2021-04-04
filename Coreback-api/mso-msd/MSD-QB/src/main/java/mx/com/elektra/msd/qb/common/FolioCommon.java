package mx.com.elektra.msd.qb.common;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;


@Component
public class FolioCommon {

	public String getFolio() {
		LocalDateTime localDateTime = LocalDateTime.now();
		Pattern p = Pattern.compile("[-:T.]");
		Matcher m = p.matcher(localDateTime.toString());
		String remplazo = null;
		if (m.find()) {
			remplazo = m.replaceAll("");
		}
		return ConstantesCommon.ID_MSD + "-" + remplazo.substring(0, 16) + "00";

	}
}
