package br.edu.uepb.sigeris.controllers;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.enterprise.inject.Model;

/**
 * Classe utilitária que provê métodos relacionados a datas. Anotada com um bean
 * CDI, pode ser usada diretamente nas páginas.
 * 
 * @author elisangela <elisangeladesouza@gmail.com>
 */
@Model
public class DateTimeUtilBean implements Serializable {

	private static final long serialVersionUID = 1L;

//	private Date date = new Date();
	private LocalDateTime now = LocalDateTime.now();
	Calendar calendar = new GregorianCalendar();

	public DateTimeUtilBean() {

	}

	public Date getDateToday() {
		return new Date();
	}

	public String getCurrentMonthAsString() {
		int monthAsInt;
		String monthAsString = "";

		// Returns the month in numbers by range 0-11
		monthAsInt = this.calendar.get(Calendar.MONTH);

		switch (monthAsInt) {
		case 0:
			monthAsString = "Janeiro";
			break;
		case 1:
			monthAsString = "Fevereiro";
			break;
		case 2:
			monthAsString = "Março";
			break;
		case 3:
			monthAsString = "Abril";
			break;
		case 4:
			monthAsString = "Maio";
			break;
		case 5:
			monthAsString = "Junho";
			break;
		case 6:
			monthAsString = "Julho";
			break;
		case 7:
			monthAsString = "Agosto";
			break;
		case 8:
			monthAsString = "Setembro";
			break;
		case 9:
			monthAsString = "Outubro";
			break;
		case 10:
			monthAsString = "Novembro";
			break;
		case 11:
			monthAsString = "Dezembro";
			break;
		default:
			break;
		}
		return monthAsString;
	}

	public String getDate() {
		DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		return data.format(now);
	}

	public String getHour() {
		DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm");
		return hora.format(now);
	}

}
