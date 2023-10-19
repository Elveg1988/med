package prof;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Utils {
	public static String dateISO = "\\d{4}-\\d{2}-\\d{2}";
	public static SimpleDateFormat formatDateISO = new SimpleDateFormat("yyyy-MM-dd");
	public static String dateRus = "\\d{2}.\\d{2}.\\d{4}";
	public static SimpleDateFormat formatDateRus = new SimpleDateFormat("dd/MM/yyyy");
	public static String numInt = "\\d+";
	public static String numReal = "\\d+[.,]?\\d{0,2}";

	public static boolean validDateISO(String d) {
		boolean valid = true;
		if (!d.matches(dateISO)) {
			System.out.println("not valid iso date");
			return !valid;
		}
		int year = Integer.valueOf(d.substring(0, 4));
		int month = Integer.valueOf(d.substring(5, 7));
		int day = Integer.valueOf(d.substring(8));
		if (year < 1900 || year > 2222) {
			System.out.println("not valid year");
			return !valid;
		}
		if (month < 1 || month > 12) {
			System.out.println("not valid month");
			return !valid;
		}
		if (day < 1 || day > 31) {
			System.out.println("not valid day");
			return !valid;
		}
		Date date = null;
		try {
			date = formatDateISO.parse(d);
			if (!formatDateISO.format(date).equals(d)) {
				System.out.println("not valid iso date");
				return !valid;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return !valid;
		}
		return valid;
	}

	public static boolean validDateRus(String d) {
		boolean valid = true;
		if (!d.matches(dateRus)) {
			System.out.println("not valid rus date");
			return !valid;
		}
		int year = Integer.valueOf(d.substring(6));
		int month = Integer.valueOf(d.substring(3, 5));
		int day = Integer.valueOf(d.substring(0, 2));
		if (year < 1900 || year > 2222) {
			System.out.println("not valid year");
			return !valid;
		}
		if (month < 1 || month > 12) {
			System.out.println("not valid month");
			return !valid;
		}
		if (day < 1 || day > 31) {
			System.out.println("not valid day");
			return !valid;
		}
		Date date = null;
		String delimiter = d.substring(2, 3);
		if (delimiter.equals(".")) {
			d = d.replaceAll("\\.", "/");
		} else if (!delimiter.equals("/")) {
			d = d.replaceAll(delimiter, "/");
		}
		try {
			date = formatDateRus.parse(d);
			if (!formatDateRus.format(date).equals(d)) {
				System.out.println("not valid rus date");
				return !valid;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return !valid;
		}
		return valid;
	}

	public static String convDateRus2ISO(String d) {
		if (!validDateRus(d)) {
			return null;
		}
		String delimiter = d.substring(2, 3);
		if (delimiter.equals(".")) {
			d = d.replaceAll("\\.", "/");
		} else if (!delimiter.equals("/")) {
			d = d.replaceAll(delimiter, "/");
		}
		try {
			Date date = formatDateRus.parse(d);
			return formatDateISO.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String convDateISO2Rus(String d) {
		if (!validDateISO(d)) {
			return null;
		}
		try {
			Date date = formatDateISO.parse(d);
			return formatDateRus.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static HashMap<String, Integer> getAge(String dt1, String dt2) {
		HashMap<String, Integer> x = null;
		if (validDateRus(dt1) && validDateRus(dt2)) {
			try {
				String delimiter = dt1.substring(2, 3);
				if (delimiter.equals(".")) {
					dt1 = dt1.replaceAll("\\.", "/");
				} else if (!delimiter.equals("/")) {
					dt1 = dt1.replaceAll(delimiter, "/");
				}
				delimiter = dt2.substring(2, 3);
				if (delimiter.equals(".")) {
					dt2 = dt2.replaceAll("\\.", "/");
				} else if (!delimiter.equals("/")) {
					dt2 = dt2.replaceAll(delimiter, "/");
				}
				Date date1 = formatDateRus.parse(dt1);
				Date date2 = formatDateRus.parse(dt2);
				if (date1.compareTo(date2) <= 0) {
					x = new HashMap<String, Integer>();
					int y1 = Integer.valueOf(dt1.substring(6, 10));
					int m1 = Integer.valueOf(dt1.substring(3, 5));
					int d1 = Integer.valueOf(dt1.substring(0, 2));
					int y2 = Integer.valueOf(dt2.substring(6, 10));
					int m2 = Integer.valueOf(dt2.substring(3, 5));
					int d2 = Integer.valueOf(dt2.substring(0, 2));
					int y3 = y2 - y1;
					if (m2 < m1) {
						y3--;
						m2 = m2 + 12;
					}
					if (m2 == m1 && d2 < d1) {
						y3--;
						m2 = m2 + 12;
					}
					int m3 = m2 - m1;
					if (d2 < d1) {
						m3--;
					}
					LocalDate ld3 = null;
					if ((m1 + m3) > 12) {
						ld3 = LocalDate.of(y1 + y3 + 1, m1 + m3 - 12, d1);
					} else {
						ld3 = LocalDate.of(y1 + y3, m1 + m3, d1);
					}
					Date date3 = java.util.Date.from(ld3.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
					System.out.println(formatDateRus.format(date3));
					int d3 = (int) ((date2.getTime() - date3.getTime()) / 24 / 60 / 60 / 1000);
					x.put("year", y3);
					x.put("month", m3);
					x.put("day", d3);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return x;
	}

	public static boolean validNumInt(String n) {
		boolean valid = true;
		if (!n.matches(numInt)) {
			System.out.println("not valid integer number");
			return !valid;
		}
		if (n.length() > 9) {
			System.out.println("very big integer number");
			return !valid;
		}
		return valid;
	}

	public static boolean validNumReal(String n) {
		boolean valid = true;
		if (!n.matches(numReal)) {
			System.out.println("not valid real number");
			return !valid;
		}
		return valid;
	}

	public static Integer getInt(String n) {
		if (!validNumInt(n)) {
			return null;
		}
		return Integer.valueOf(n);
	}

	public static Double getDouble(String n) {
		if (!validNumReal(n)) {
			return null;
		}
		return Double.valueOf(n);
	}

	public static String calcHash(char[] word) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] ba = new String(word).getBytes(StandardCharsets.UTF_8);
			messageDigest.update(ba);
			return Base64.getEncoder().encodeToString(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			JOptionPane.showMessageDialog(null, "SHA-256 не поддерживается", "Предупреждение: ",
					JOptionPane.INFORMATION_MESSAGE);
			return null;
		}
	}

	public static void main(String[] args) {
		String d1 = "12/11/1966";
		String d2 = "11/11/1967";
		System.out.println(getAge(d1, d2));
		String n1 = "999999999";
		System.out.println(validNumInt(n1));
		System.out.println(getInt(n1));
		String n2 = "999999999.99";
		System.out.println(validNumReal(n2));
		System.out.println(String.format("%.02f", getDouble(n2)));
	}
}
