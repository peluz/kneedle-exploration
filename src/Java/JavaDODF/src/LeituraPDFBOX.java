import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//import org.apache.commons.math3.stat.descriptive.rank;
//import org.apache.commons.math3.stat.StatUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Elaborado por Marceo Magalhães Silva de Sousa em Abril de 2019. 
 * Permitida a utilização deste código, desde que citada expressamente a autoria.
 */
public class LeituraPDFBOX extends PDFTextStripper {
	
	public LeituraPDFBOX() throws IOException {
		super();
	}
	/**
	 * @throws IOException
	 *             If there is an error parsing the document.
	 */
	public static void main(String[] args) throws IOException {
		System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");

		String fileName;
		//File file;
		
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 209 01-11-2018 INTEGRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 214 09-11-2018 INTEGRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 210 05-11-2018 INTEGRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 218 16-11-2018 INTEGRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 219 19-11-2018 INTEGRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 211 06-11-2018 INTEGRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 212 07-11-2018 INTEGRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 209 01-11-2018 SUPLEMENTO A.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 071 01-11-2018 EDICAO EXTRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 217 14-11-2018 INTEGRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 076 16-11-2018 EDICAO EXTRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 216 13-11-2018 INTEGRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 222 22-11-2018 INTEGRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 215 12-11-2018 INTEGRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 226 28-11-2018 INTEGRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 221 21-11-2018 INTEGRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 213 08-11-2018 INTEGRA.pdf";
		
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 223 23-11-2018 INTEGRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\11\\DODF 213 08-11-2018 INTEGRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\12\\DODF 241 20-12-2018 INTEGRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2018\\12\\DODF 228 03-12-2018 INTEGRA.pdf";
		
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2019\\01\\DODF 005 08-01-2019 INTEGRA.pdf";
		
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2019\\01\\DODF 009 14-01-2019 INTEGRA.pdf";
		
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2019\\01\\DODF 001 02-01-2019 INTEGRA.pdf";
		//fileName = "C:\\TesteOCR\\DODF\\DODF downloads\\2019\\01\\DODF 003 11-01-2019 EDICAO EXTRA.pdf";
		
		
		fileName = args[0];
		
		
		File file = new File(fileName);
		PDDocument document = null;

		try {
			document = PDDocument.load(new File(fileName));
			
			LeituraPDFBOX stripper = new LeituraPDFBOX();


						
			List<Integer> listaNumeroDODF = new ArrayList<>();
			List<String> listaDataDODF = new ArrayList<>();
			List<String> listaComplementoDODF = new ArrayList<>();
					
			boolean showNumeroDODF = true;
			boolean showDataDODF = true;
			boolean showComplementoDODF = true;			
			int posicaoSecao = 0;
			int page = 0;
			int contadorImagens = 1;
			List<Linha> textocompletoFinal = new ArrayList<>();
			//boolean secao = true;
			
			boolean secao = false;
			// for (int page = 1; page < document.getNumberOfPages(); page++)
			// for (int page = 44; page < 45; page++) {
			// for (int page = 45; page < 46; page++) {
			// for (int page = 95; page < 96; page++) {
			// for (int page = 94; page < 95; page++) {
			//for (int p = page; p < 53; p++) {
			//for (page = 1; page < document.getNumberOfPages(); page++) {
			//for (page = 52; page < 53; page++) {
			//for (page = 84; page < 85; page++) {
			//for (page = 68; page < 69; page++) {
			//for (page = 33; page < 34; page++) {
			//for (page = 35; page < 36; page++) {
			//for (page = 120; page < 212; page++) {
			//for (page = 71; page < 72; page++) {
			//for (int p = 45; p < 46; p++) {
			//for (int p = 82; p < 83; p++) {
			//for (int p = 51; p < 52; p++) {
			//for (int p = 36; p < 37; p++) {
			//for (int p = 47; p < 48; p++) {
			//for (page = 41; page < 42; page++) {
			//for (page = 95; page < 96; page++) {
			//outloop:
			//for (int p = 11; p < 12; p++) {
			//for (int p = 94; p < 95; p++) {
			//for (int p = 42; p < 43; p++) {
			//for (int p = 30; p < 31; p++) {
			//for (int p = 47; p < 48; p++) {
			//for (page = 71; page < 72; page++) {
			//for (page = 6; page < 7; page++) {
			//for (page = 30; page < 31; page++) {
			//System.out.println("numeber of pages: " + document.getNumberOfPages());
			outloop:
			for (int p = 0; p < document.getNumberOfPages(); p++) {				
				//setPage(p);							
				
				page = p + 1;
				//System.out.println("Processando página " + page + " ...");
				int numero_DODF = 0;
				String data_DODF = "";
				String complemento_DODF = "";				
				
				List<Linha> bloco1 = new ArrayList<>();
				List<List<Linha>> bloco1_temp = new ArrayList<>();
				List<Linha> bloco1_parcial = new ArrayList<>();
				List<List<Linha>> bloco2 = new ArrayList<>();
				List<Linha> bloco2_temp = new ArrayList<>();
				List<Linha> listaElementos = new ArrayList<>();
				
				List<List<Linha>> bloco = new ArrayList<>();
				List<Linha> bloco_parcial = new ArrayList<>();				
				
				float yAntecedente = 0;
				float xAntecedente = 0;
				boolean secretariaFlutuante = false;
				boolean processaBloco1 = false;
				//boolean processaBloco2 = false;
				int contador = 0;				
				
				Linha registroElemento = new Linha("", 0, 0, 0, "", 0,
						0, 0, 0, page, 0, "01/01/2000");
				stripper.setStartPage(page);
				stripper.setEndPage(page);
				

				// StringWriter dummy = new StringWriter();

				Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
				stripper.writeText(document, dummy);

				// stripper.setSortByPosition( true );
				List<List<TextPosition>> vectorlistoftps = stripper.getCharactersByArticle();
				// System.out.println(vectorlistoftps.size());

				// boolean bloco2 = false;
				//System.out.println(vectorlistoftps.size());
				
				for (int i = 0; i < vectorlistoftps.size(); i++) {
					
					List<TextPosition> tplist = vectorlistoftps.get(i);

					// PDPage thisPage = stripper.getCurrentPage();

					// System.out.println(tplist.size());

					StringBuilder builder = new StringBuilder();
					int contadorLinhas = -1;
					int cont = -1;
					int contadorLinhasBlocoParcial = -1;
					int saidaBloco = 100;
					boolean existeTabela = false;
					float startX = 0;
					float startY = 0;
					float Xo = 0;
					float endY = 0;
					String endFontFamily = "";
					float height = 0;
					float xscale = 0;
					float space = 0;
					float fontSizePT = 0;
					float Xf = 0;
					float prevXf = 0;
					//int contadorElementos = 0;

					for (int j = 0; j < tplist.size() ; j++) {

						TextPosition position = tplist.get(j);

						if (prevXf == 0) {
							prevXf = position.getEndX();
						}
											

						/*
						 * if (prevY == 0) { prevY = position.getY(); }
						 */

						cont = cont + 1;
						if (cont == 0) {
							startX = position.getX();
							startY = position.getY();														
							Xo = position.getX();
							Xf = position.getEndX();
							endY = position.getY();
							endFontFamily = position.getFont().getFontDescriptor().getFontName();
							height = position.getHeightDir();
							fontSizePT = position.getFontSizeInPt();
							xscale = position.getXScale();
							space = position.getWidthOfSpace();

						} else {
							Xo = position.getX();
							endY = position.getY();
							Xf = position.getEndX();
							endFontFamily = position.getFont().getFontDescriptor().getFontName();
							height = position.getHeightDir();
							fontSizePT = position.getFontSizeInPt();
							xscale = position.getXScale();
							space = position.getWidthOfSpace();
						}

						//System.out.println(position.getUnicode());
						//System.out.println(position.getFontSizeInPt());
											
						
						//if (Math.abs(startY - endY) <= 0.001 && Math.abs(Xo - prevXf) <= 15) { // verificar se não tem que ser menor
						if (Math.abs(startY - endY) <= 0.001 && Math.abs(Xo - prevXf) <= 15 && registroElemento.fontSizePT == fontSizePT) { // verificar se não tem que ser menor
							// if (Math.abs(Xo - prevXf) <= 10 && Math.abs(Xo - prevXf) >= 2 && cont > 0) {
							//System.out.println(fontSizePT);
							
							//if (Math.abs(Xo - prevXf) >= 2 && cont > 0) {
							if (Math.abs(Xo - prevXf) >= 1.5 && cont > 0) {								
							//if (Math.abs(Xo - prevXf) >= 2.5 && cont > 0) {
								// if (Xo - prevXf >= 3 && cont > 0) {
								// System.out.println(Xo);
								// System.out.println(prevXf);
								if (Xo >= prevXf) {
									builder.append(" " + position.getUnicode());
									registroElemento = new Linha(builder.toString(), startX, Xf, endY, endFontFamily, fontSizePT,
											height, xscale, space, page, 0, "01/01/2019");
									prevXf = Xf;
									//prevFontSizePT = fontSizePT;
									//contadorElementos = contadorElementos + 1;
									// listaElementos.add(registroElemento);
									// registroElemento.setTexto(builder.toString());
								} else {
									if (position.getUnicode().equals(" ") == false) {
										builder.append(position.getUnicode());
										registroElemento = new Linha(builder.toString(), startX, Xf, endY, endFontFamily, fontSizePT,
												height, xscale, space, page, 0, "01/01/2019");
										prevXf = Xf;
										//System.out.println(position.getUnicode());	
										//prevXf = Xf;
									}
																										
								}
																
							} else {

								//System.out.println(builder.toString());
								if (position.getUnicode().equals(" ")) {
									// System.out.println("branco");
									/*
									if (Math.abs(Xo - prevXf) <= 0) {
										builder.append(position.getUnicode());
										registroElemento = new Linha("", startX, Xf, endY, endFontFamily,
												fontSizePT, height, xscale, space, page, 0, "01/01/2019");	
									}										
									*/									
									
									if (Math.abs(Xo - prevXf) <= 0.2) {

										if (tplist.size() > j + 1) {
										
											TextPosition proximoElemento = tplist.get(j+1);											

											//if (registroElemento.endX != proximoElemento.getX()) {
											if (proximoElemento.getX() - registroElemento.endX > 0.2) {
												
												//System.out.println(position.getUnicode());	
												builder.append(position.getUnicode());
												registroElemento = new Linha(builder.toString(), startX, Xf, endY, endFontFamily, fontSizePT,
														height, xscale, space, page, 0, "01/01/2019");
												prevXf = Xf;
												//prevFontSizePT = fontSizePT;
												//contadorElementos = contadorElementos + 1;	
												
											}
											
										} else {
											//System.out.println(position.getUnicode());	
											builder.append(position.getUnicode());
											registroElemento = new Linha(builder.toString(), startX, Xf, endY, endFontFamily, fontSizePT,
													height, xscale, space, page, 0, "01/01/2019");
											prevXf = Xf;
											//prevFontSizePT = fontSizePT;
											//contadorElementos = contadorElementos + 1;																						
										}									
																										
									}

								} else {
									builder.append(position.getUnicode());
									registroElemento = new Linha(builder.toString(), startX, Xf, endY, endFontFamily, fontSizePT,
											height, xscale, space, page, 0, "01/01/2019");
									prevXf = Xf;
									//prevFontSizePT = fontSizePT;
									//contadorElementos = contadorElementos + 1;
								}

							}
							
							//prevFontSizePT = fontSizePT;
							
						} else { //ver esse final (fecha lá embaixo)
							
							//System.out.println(builder.toString().replace("  ", " "));  //#controle
							registroElemento.setTexto(builder.toString().replace("  ", " "));
							//registroElemento.setTexto(registroElemento.texto.replace("  ", " "));
							
							listaElementos.add(registroElemento);
							//registroElemento.setTexto(builder.toString().replace("  ", " "));
							//System.out.println(secao);
							
							

							
							startX = position.getX();
							Xo = position.getX();
							endY = position.getY();
							Xf = position.getEndX();
							endFontFamily = position.getFont().getFontDescriptor().getFontName();
							height = position.getHeightDir();
							fontSizePT = position.getFontSizeInPt();
							xscale = position.getXScale();
							
							space = position.getWidthOfSpace();
							builder = new StringBuilder();
							builder.append(position.getUnicode());

							startY = position.getY();
							prevXf = Xf;
							//prevFontSizePT = fontSizePT;
							
							// cont = 0;

							registroElemento = new Linha("", startX, Xf, endY, endFontFamily, fontSizePT, height,
									xscale, space, page, 0, "01/01/2019");	

						} //fecha com else

					} //fim do for do article

					//System.out.println(Xo);
					//System.out.println(Xf);
					//System.out.println(builder.toString());

					registroElemento.setTexto(builder.toString().replace("  ", " "));
					//registroElemento.setTexto(registroElemento.texto.replace("  ", " "));
					listaElementos.add(registroElemento);
					
					
					//posicaoSecao = 0;
					
					for (int j = 0; j <= listaElementos.size() - 1; ++j) {
						registroElemento = listaElementos.get(j);
						
						//System.out.println(builder.toString().replace("  ", " "));  //#controle
						//registroElemento.setTexto(builder.toString().replace("  ", " "));
						//System.out.println(registroElemento.texto);  //#controle							
						
					
						secao = procuraSecao(secao, registroElemento, page);
							

						int numero = 0;							
						numero = procuraNumeroDODF(listaElementos, registroElemento, page, numero_DODF);							
						if (numero != 0) {
								if (showNumeroDODF && numero_DODF == 0) {
									System.out.println("DODF Nº: " + numero);  //#controle	
									showNumeroDODF = false;
								}
								numero_DODF = numero;
								listaNumeroDODF.add(numero_DODF);
						}																					
						
						
						String complemento = "";						
						complemento = procuraComplementoDODF(listaElementos, registroElemento, page, complemento_DODF);							
						//System.out.println("resultaado " + complemento);
						if (complemento != "") {
								if (showDataDODF && complemento_DODF == "") {
									System.out.println("COMPLEMENTO DO DODF: " + complemento);  //#controle	
									showDataDODF = false;
								}	
								complemento_DODF = complemento;
								listaComplementoDODF.add(complemento_DODF);
								//System.out.println("get0 " + listaComplementoDODF.get(0));

						}								
						
						
						
						String data = encontraDataDODF(registroElemento, page, data_DODF);					
						if (data != "") {
							if (showComplementoDODF && data_DODF == "") {
								System.out.println("DATA DO DF: " + data); //#controle	
								showComplementoDODF = false;
							}						
							data_DODF = data;
							listaDataDODF.add(data_DODF);									
						}
					
					}
					
					if (secao == true) {
					
						for (int j = posicaoSecao; j <= listaElementos.size() - 1; ++j) {
						
						
							
							registroElemento = listaElementos.get(j);
							//registroElemento.setTexto(builder.toString().replace("  ", " "));
							//System.out.println(registroElemento.texto);							
							
							//List<List<Linha>> bloco = new ArrayList<>();
							//List<Linha> bloco_parcial = new ArrayList<>();								
							
							//bloco2.add(bloco2_temp);
							//bloco2_temp = new ArrayList<>();	
							
							// listaElementos.add(registroElemento);

							if (registroElemento.endY >= 80 && registroElemento.endY <= 880) {
								
								//System.out.println(registroElemento.texto);
								contadorLinhas = contadorLinhas + 1;
								contadorLinhasBlocoParcial = contadorLinhasBlocoParcial + 1;
								
								if (registroElemento.fontSizePT == 0 && registroElemento.texto.equals(".")) {
									//existeTabela = true;
									//saidaBloco = 100;
								}
								
								
								
								if (bloco_parcial.size() == 0) {
									bloco_parcial.add(registroElemento);
									yAntecedente = registroElemento.endY;
									xAntecedente = registroElemento.endX;
								} else {
									//if (Math.abs(registroElemento.endY - yAntecedente) >= 100 && (registroElemento.startX - xAntecedente > 30) {
									//if ((Math.abs(registroElemento.endY - yAntecedente) >= saidaBloco || registroElemento.endY < Collections.max(bloco_parcial, Comparator.comparing(c -> c.getY())).endY) && existeTabela == false) {											
									
									for (int k = 0; k <= bloco_parcial.size() - 1; ++k) {
										if (bloco_parcial.get(k).fontSizePT == 0 && bloco_parcial.get(k).texto.equals(".")) {
											//existeTabela = true;
											//saidaBloco = 300;
											//break;
										}											
									}	
									
									if ((Math.abs(registroElemento.endY - yAntecedente) >= saidaBloco) && existeTabela == false) {											
									//if (Math.abs(registroElemento.endY - yAntecedente) >= 200 || (Math.abs(registroElemento.endY - yAntecedente) >= 50 && bloco_parcial.get(contadorLinhas - 1).endX - registroElemento.endX > 300)) {											
										if (verificaBlocoUnico(bloco_parcial)) {
											
											
											
											//bloco_parcial.add(registroElemento);	
											
											List<Float> bloco1Y = new ArrayList<>();
											List<Float> bloco2Y = new ArrayList<>();
											
											
											for (int k = 0; k <= bloco_parcial.size() - 1; ++k) {
												//System.out.println(bloco_parcial.get(k).texto);
											}												
											
											for (int k = 0; k <= bloco_parcial.size() - 1; ++k) {
												if (bloco_parcial.get(k).startX >= 40 && bloco_parcial.get(k).startX < 415
										        		//&& bloco_parcial.get(k).endX <= 415
										        		&& bloco_parcial.get(k).endY >= 80
														&& bloco_parcial.get(k).endY <= 880  ) {
													//bloco1_parcial.add(bloco_parcial.get(k));
													bloco1Y.add(bloco_parcial.get(k).endY);
													//bloco_parcial.remove(bloco_parcial.get(k));
												}		
											}

											
											float minYBloco1 = Collections.min(bloco1Y) - 5;
											float maxYBloco1 = Collections.max(bloco1Y) + 5;
											
											//System.out.println(minYBloco1);
											//System.out.println(maxYBloco1);
											//System.out.println(existeTabela);

											for (int k = 0; k <= bloco_parcial.size() - 1; ++k) {
												if (bloco_parcial.get(k).endY >= minYBloco1
														&& bloco_parcial.get(k).endY <= maxYBloco1  ) {
													bloco1_parcial.add(bloco_parcial.get(k));
													//System.out.println(bloco_parcial.get(k).texto);	
													//bloco_parcial.remove(k);
													//bloco1Y.add(bloco_parcial.get(k).endY);
													//bloco_parcial.remove(bloco_parcial.get(k));
												}		
											}
											

											
											for (int k = 0; k <= bloco_parcial.size() - 1; ++k) {
												if (bloco_parcial.get(k).endY >= 80
														&& bloco_parcial.get(k).endY < minYBloco1) {
													bloco2_temp.add(bloco_parcial.get(k));	
																											
												}
											}									

											
											if (bloco1_parcial.size() > 0)  {
												bloco1_temp.add(bloco1_parcial);
												bloco1_parcial = new ArrayList<>();	
											}
											
											if (bloco2_temp.size() > 0)  {
												bloco2.add(bloco2_temp);
												bloco2_temp = new ArrayList<>();
											}										
											
											//bloco1_parcial.add(registroElemento);
											//bloco1_temp.add(bloco_parcial);
											//bloco_parcial = new ArrayList<>();
											//System.out.println("bloco unico!");
											
											bloco_parcial = new ArrayList<>();
											//existeTabela = false;
											//saidaBloco = 100;
											bloco_parcial.add(registroElemento);
											
										} else {
											
											
											for (int k = 0; k <= bloco_parcial.size() - 1; ++k) {
												if (bloco_parcial.get(k).startX >= 40 && bloco_parcial.get(k).startX < 415
										        		&& bloco_parcial.get(k).endX <= 415
										        		&& bloco_parcial.get(k).endY >= 80
														&& bloco_parcial.get(k).endY <= 880  ) {
													bloco1_parcial.add(bloco_parcial.get(k));																									
												}							
												else if (bloco_parcial.get(k).startX >= 415 && bloco_parcial.get(k).endX > 415
										        		&& bloco_parcial.get(k).endY >= 80
														&& bloco_parcial.get(k).endY <= 880  ) {
													bloco2_temp.add(bloco_parcial.get(k));	
																											
												}	
											}													
											
											if (bloco1_parcial.size() > 0)  {
												bloco1_temp.add(bloco1_parcial);
												bloco1_parcial = new ArrayList<>();	
											}
											
											if (bloco2_temp.size() > 0)  {
												bloco2.add(bloco2_temp);
												bloco2_temp = new ArrayList<>();
											}								
											
											
											//bloco2.add(bloco2_temp);												
											//bloco2_temp = new ArrayList<>();
											bloco_parcial = new ArrayList<>();
											//existeTabela = false;
											//saidaBloco = 100;
											bloco_parcial.add(registroElemento);

										}
										
										//existeTabela = false;
										yAntecedente = registroElemento.endY;
										xAntecedente = registroElemento.endX;
										
									} else {
										bloco_parcial.add(registroElemento);
										yAntecedente = registroElemento.endY;
										xAntecedente = registroElemento.endX;
									}
									// (Math.abs(registroElemento.endY - yAntecedente) >= 200 )
									
								}
		
							}

							
							if (j == listaElementos.size() - 1) {
																							
								
								//System.out.println(registroElemento.texto);
								
								if (bloco_parcial.size() > 0) {

									for (int k = 0; k <= bloco_parcial.size() - 1; ++k) {
										//System.out.println(bloco_parcial.get(k).texto);
									}	
									
									
									if (verificaBlocoUnico(bloco_parcial)) {
										
										//bloco_parcial.add(registroElemento);	
										
										List<Float> bloco1Y = new ArrayList<>();
										List<Float> bloco2Y = new ArrayList<>();
										
										for (int k = 0; k <= bloco_parcial.size() - 1; ++k) {
											if (bloco_parcial.get(k).startX >= 40 && bloco_parcial.get(k).startX < 415
									        		//&& bloco_parcial.get(k).endX <= 415
									        		&& bloco_parcial.get(k).endY >= 80
													&& bloco_parcial.get(k).endY <= 880  ) {
												//bloco1_parcial.add(bloco_parcial.get(k));
												bloco1Y.add(bloco_parcial.get(k).endY);
												//bloco_parcial.remove(bloco_parcial.get(k));
											}		
										}

										
										float minYBloco1 = Collections.min(bloco1Y) - 5;
										float maxYBloco1 = Collections.max(bloco1Y) + 5;
										
										//System.out.println(minYBloco1);
										//System.out.println(maxYBloco1);

										for (int k = 0; k <= bloco_parcial.size() - 1; ++k) {
											if (bloco_parcial.get(k).endY >= minYBloco1
													&& bloco_parcial.get(k).endY <= maxYBloco1  ) {
												bloco1_parcial.add(bloco_parcial.get(k));
												//System.out.println(bloco_parcial.get(k).texto);	
												//bloco_parcial.remove(k);
												//bloco1Y.add(bloco_parcial.get(k).endY);
												//bloco_parcial.remove(bloco_parcial.get(k));
											}		
										}
										

										
										for (int k = 0; k <= bloco_parcial.size() - 1; ++k) {
											if (bloco_parcial.get(k).endY >= 80
													&& bloco_parcial.get(k).endY < minYBloco1  ) {
												bloco2_temp.add(bloco_parcial.get(k));	
																										
											}
										}									

										
										if (bloco1_parcial.size() > 0)  {
											bloco1_temp.add(bloco1_parcial);
											bloco1_parcial = new ArrayList<>();	
										}
										
										if (bloco2_temp.size() > 0)  {
											bloco2.add(bloco2_temp);
											bloco2_temp = new ArrayList<>();
										}										
										
										//bloco1_parcial.add(registroElemento);
										//bloco1_temp.add(bloco_parcial);
										//bloco_parcial = new ArrayList<>();
										//System.out.println("bloco unico!");
										
										bloco_parcial = new ArrayList<>();
										//bloco_parcial.add(registroElemento);
										
									}	else {
										
										//bloco_parcial.add(registroElemento);
										
										for (int k = 0; k <= bloco_parcial.size() - 1; ++k) {
											if (bloco_parcial.get(k).startX >= 40 && bloco_parcial.get(k).startX < 415
									        		&& bloco_parcial.get(k).endX <= 415
									        		&& bloco_parcial.get(k).endY >= 80
													&& bloco_parcial.get(k).endY <= 880  ) {
												bloco1_parcial.add(bloco_parcial.get(k));																									
											}							
											else if (bloco_parcial.get(k).startX >= 415 && bloco_parcial.get(k).endX > 415
									        		&& bloco_parcial.get(k).endY >= 80
													&& bloco_parcial.get(k).endY <= 880  ) {
												bloco2_temp.add(bloco_parcial.get(k));	
																										
											}	
										}													
										
										if (bloco1_parcial.size() > 0)  {
											bloco1_temp.add(bloco1_parcial);
											bloco1_parcial = new ArrayList<>();	
										}
										
										if (bloco2_temp.size() > 0)  {
											bloco2.add(bloco2_temp);
											bloco2_temp = new ArrayList<>();
										}								
										
										
										//bloco2.add(bloco2_temp);												
										//bloco2_temp = new ArrayList<>();
										bloco_parcial = new ArrayList<>();
										//bloco_parcial.add(registroElemento);

									}								
									
								}

								
								
							
							}						
						
							
						}						
						
						
					}
						
						
						
					
					
					
				
						
						//System.out.println("----------------- BLOCO 1 -----------------------"); //#controle										
						//System.out.println(bloco1_temp.size()); // Número de camadas que o Bloco1 foi formado #controle
						

						
						for (int j = 0; j <= bloco1_temp.size() - 1; ++j) {
							List<Linha> temp = new ArrayList<>();								
							temp.addAll(bloco1_temp.get(j));
							//temp.addAll(1, bloco1_temp.get(j));
							
							//System.out.println(" > " + temp.size()); // Número de linhas em cada camada #controle
							for (int k = 0; k <= temp.size() - 1; k++)
							{
								//System.out.println("	" +temp.get(k).texto); // Linhas de cada camada #controle 
							}
						}					
						
						List<Float> listaMinY = new ArrayList<>();
						float maxAnterior = 70;
						float maxY = 80;
						float minY = 80;
						Map<Float, List<Linha>> dictionary = new HashMap<Float, List<Linha>>();	
						List<List<Linha>> bloco1_new = new ArrayList<>();
						
						
						if (bloco1_temp.size() > 0) {
							
							//Map<Float, List<Linha>> dictionary2 = new HashMap<Float, List<Linha>>();	
							//boolean pular = false;
							if (bloco1_temp.size() > 1) {
								for (int j = 0; j <= bloco1_temp.size() - 1; ++j) {
									//if (pular) {
									//	pular = false;
									//	continue;										
									//}
									
									//System.out.println("size: " + bloco1_temp.get(j).size());
									
									
									bloco1_parcial = new ArrayList<>();				
									bloco1_parcial.addAll(bloco1_temp.get(j));
				
									if (j == 0) {
										minY = Collections.min(bloco1_parcial, Comparator.comparing(c -> c.getY())).endY;
										//System.out.println(minY);
										maxY = Collections.max(bloco1_parcial, Comparator.comparing(c -> c.getY())).endY;
										bloco1_new.add(bloco1_parcial);
										//System.out.println(maxY);
									} else {
										if (minY < Collections.max(bloco1_parcial, Comparator.comparing(c -> c.getY())).endY && maxY > Collections.min(bloco1_parcial, Comparator.comparing(c -> c.getY())).endY) {
											//bloco1_new.remove(j-1);
											//System.out.println("TEM INTERSEÇÃO COMPLETA ENTRE O ELEMENTO " + j + " COM O " + (j - 1));
											//System.out.println(minY);
											//System.out.println(maxY);											
											//System.out.println("qual o j " + j);
											//System.out.println(Collections.min(bloco1_parcial, Comparator.comparing(c -> c.getY())).endY);
											//System.out.println(Collections.max(bloco1_parcial, Comparator.comparing(c -> c.getY())).endY);											
											
									    	//List<Float> a = new ArrayList<>();
									    	//a.add((float) minY);
									    	//a.add((float) maxY);      	
									    	//List<Float> b = new ArrayList<>();
									    	//b.add((float) Collections.min(bloco1_parcial, Comparator.comparing(c -> c.getY())).endY);
									    	//b.add((float) Collections.max(bloco1_parcial, Comparator.comparing(c -> c.getY())).endY);
									  	
											minY = Math.max(minY, Collections.min(bloco1_parcial, Comparator.comparing(c -> c.getY())).endY);
											maxY = Math.min(maxY, Collections.max(bloco1_parcial, Comparator.comparing(c -> c.getY())).endY);
											//System.out.println(minY);
											//System.out.println(maxY);
											
											if (bloco1_temp.get(j).size() > bloco1_temp.get(j - 1).size()) {
												
												if (j - 1 < bloco1_new.size()) {
													bloco1_new.remove(j - 1);
												}
												bloco1_parcial = new ArrayList<>();
												
												List<Float> listaDistanciaY = new ArrayList<>();
												int elementoAntecedente = 0;
												for (int k = 0; k <= bloco1_temp.get(j).size() - 1; ++k) {
													//dicionario.put(listaLinhas.get(k).endY - y_atual,k);
													listaDistanciaY.add(bloco1_temp.get(j).get(k).endY - minY);
													//contadorElementosBloco = contadorElementosBloco + 1;
												}
												
												Collections.sort(listaDistanciaY);
												
												for (int k = 0; k <= listaDistanciaY.size() - 1; ++k) {					
													if (listaDistanciaY.get(k) >= 0) {						
														elementoAntecedente = k - 1;
														break;
													}	
												}		
												
												for (int k = 0; k <= elementoAntecedente; ++k) {
													//dicionario.put(listaLinhas.get(k).endY - y_atual,k);
													//elementoAntecedente
													//System.out.println(bloco1_temp.get(j).get(k).texto);
													bloco1_parcial.add(bloco1_temp.get(j).get(k));
													//contadorElementosBloco = contadorElementosBloco + 1;
												}		
												
												//System.out.println("size: " + bloco1_temp.get(j +1).size());
												//System.out.println("size: " + bloco1_temp.get(j).size());
												//System.out.println("size: " + bloco1_temp.get(j - 1).size());
												
												for (int k = 0; k <= bloco1_temp.get(j - 1).size() - 1; ++k) {
													//dicionario.put(listaLinhas.get(k).endY - y_atual,k);
													//elementoAntecedente
													//System.out.println(bloco1_temp.get(j - 1).get(k).texto);
													//System.out.println(bloco1_temp.get(j).get(k).endY);
													bloco1_parcial.add(bloco1_temp.get(j - 1).get(k));
													//contadorElementosBloco = contadorElementosBloco + 1;
												}	
														
												
												//bloco1_parcial.addAll(bloco1_temp.get(j));
												
												for (int k = elementoAntecedente + 1; k <= bloco1_temp.get(j).size() - 1; ++k) {
													//dicionario.put(listaLinhas.get(k).endY - y_atual,k);
													//elementoAntecedente
													//System.out.println(bloco1_temp.get(j).get(k).texto);
													bloco1_parcial.add(bloco1_temp.get(j).get(k));
													//contadorElementosBloco = contadorElementosBloco + 1;
												}												
												
												
												//System.out.println(elementoAntecedente);
												//System.out.println(bloco1_parcial.get(elementoAntecedente).texto);
												//System.out.println(bloco1_parcial.get(elementoAntecedente).endY);
												
												
											} else {
												//System.out.println(j);
												//System.out.println(bloco1_new.size());
												if (j - 1 < bloco1_new.size()) {
													bloco1_new.remove(j - 1);
												}

												bloco1_parcial = new ArrayList<>();
												
												List<Float> listaDistanciaY = new ArrayList<>();
												int elementoAntecedente = 0;
												for (int k = 0; k <= bloco1_temp.get(j - 1).size() - 1; ++k) {
													//dicionario.put(listaLinhas.get(k).endY - y_atual,k);
													listaDistanciaY.add(bloco1_temp.get(j - 1).get(k).endY - minY);
													//contadorElementosBloco = contadorElementosBloco + 1;
												}
												
												Collections.sort(listaDistanciaY);
												
												for (int k = 0; k <= listaDistanciaY.size() - 1; ++k) {					
													if (listaDistanciaY.get(k) > 0) {						
														elementoAntecedente = k - 1;
														break;
													}	
												}		
												
												//System.out.println(elementoAntecedente);
												//System.out.println(bloco1_temp.get(j - 1).get(elementoAntecedente).texto);
												//System.out.println(bloco1_temp.get(j - 1).get(elementoAntecedente).endY);
												
												//bloco1_parcial = new ArrayList<>();
												
												for (int k = 0; k <= elementoAntecedente; ++k) {
													//dicionario.put(listaLinhas.get(k).endY - y_atual,k);
													//elementoAntecedente
													//System.out.println(bloco1_temp.get(j - 1).get(k).texto);
													bloco1_parcial.add(bloco1_temp.get(j - 1).get(k));
													//contadorElementosBloco = contadorElementosBloco + 1;
												}		
												
												//System.out.println("size: " + bloco1_temp.get(j +1).size());
												//System.out.println("size: " + bloco1_temp.get(j).size());
												//System.out.println("size: " + bloco1_temp.get(j - 1).size());
												
												for (int k = 0; k <= bloco1_temp.get(j).size() - 1; ++k) {
													//dicionario.put(listaLinhas.get(k).endY - y_atual,k);
													//elementoAntecedente
													//System.out.println(bloco1_temp.get(j).get(k).texto);
													//System.out.println(bloco1_temp.get(j).get(k).endY);
													bloco1_parcial.add(bloco1_temp.get(j).get(k));
													//contadorElementosBloco = contadorElementosBloco + 1;
												}	
														
												
												//bloco1_parcial.addAll(bloco1_temp.get(j));
												
												for (int k = elementoAntecedente + 1; k <= bloco1_temp.get(j - 1).size() - 1; ++k) {
													//dicionario.put(listaLinhas.get(k).endY - y_atual,k);
													//elementoAntecedente
													//System.out.println(bloco1_temp.get(j - 1).get(k).texto);
													bloco1_parcial.add(bloco1_temp.get(j - 1).get(k));
													//contadorElementosBloco = contadorElementosBloco + 1;
												}													
												
												//bloco1_new.add(bloco2_new_temp);
												//j = j + 1;
												//pular = true;
												//continue;
												
											}
					
											//} else if (minY < Collections.max(bloco1_parcial, Comparator.comparing(c -> c.getY())).endY && maxY < Collections.min(bloco1_parcial, Comparator.comparing(c -> c.getY())).endY) {
										//	System.out.println("TEM INTERSEÇÃO BAIXO Y ENTRE O ELEMENTO " + j + " COM O " + (j - 1));
											//System.out.println(minY);
											//System.out.println(minY);
										//} else if (maxY > Collections.min(bloco1_parcial, Comparator.comparing(c -> c.getY())).endY && minY > Collections.max(bloco1_parcial, Comparator.comparing(c -> c.getY())).endY ) {
											//System.out.println("TEM INTERSEÇÃO ALTO Y ENTRE O ELEMENTO " + j + " COM O " + (j - 1));
										}
										bloco1_new.add(bloco1_parcial);
										minY = Collections.min(bloco1_parcial, Comparator.comparing(c -> c.getY())).endY;
										maxY = Collections.max(bloco1_parcial, Comparator.comparing(c -> c.getY())).endY;	
									}
									

				
									
								}										
								
							} else {
								bloco1_new.addAll(bloco1_temp);
							}						
						
						
						}
						
						for (int j = 0; j <= bloco1_new.size() - 1; ++j) {
							List<Linha> temp = new ArrayList<>();								
							temp.addAll(bloco1_new.get(j));
							//System.out.println(" > " + temp.size());
							for (int k = 0; k <= temp.size() - 1; k++)
							{
								//System.out.println(temp.get(k).texto);
								//System.out.println(temp.get(k).endY);
							}
						}							
					
						
						for (int j = 0; j <= bloco1_new.size() - 1; ++j) {
							bloco1_parcial = new ArrayList<>();
							//bloco1_parcial.addAll(bloco1_new.get(j));	
							bloco1_parcial = bloco1_new.get(j);	
							//bloco1_parcial = bloco1_new.get(j);																						
							DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
							for (int k = 0; k <= bloco1_parcial.size() - 1; k++) {																		
								descriptiveStatistics.addValue(bloco1_parcial.get(k).endY);									
							}							
							//float YprimeiroElemento = bloco1_parcial.get(0).endY;
							minY = (float) descriptiveStatistics.getPercentile(50);
							//minY = Collections.min(bloco1_parcial, Comparator.comparing(c -> c.getY())).endY;
							//System.out.println(bloco1_parcial.get(0).texto);
							//System.out.println(bloco1_parcial.get(0).endY);
							dictionary.put(minY, bloco1_parcial);
							listaMinY.add(minY);							
							
						}
						
						


						Collections.sort(listaMinY);
						
						//System.out.println(listaMinY);

						
						for (int j = 0; j <= listaMinY.size() - 1; ++j) {
								bloco1.addAll(dictionary.get(listaMinY.get(j)));							
						}
								

							
							//textocompletoFinal.add(blocoCompleto.get(j));
													
						//System.out.println("----------------- BLOCO 1 COMPLETO -----------------------");	//#controle
						
						
						for (int j = 0; j <= bloco1.size() - 1; ++j) {
							//System.out.println(bloco1.get(j).texto); //Resultando do Bloco1 formado pela junção de todas as camadas que o compõe #controle
							//System.out.println(bloco1.get(j).endY);
						}						
						
						//bloco2_temp = new ArrayList<>();
						

						//
						boolean existeBlocoUnico = false;
						List<List<Linha>> bloco2Final = new ArrayList<>();
						List<Linha> bloco_1e2 = new ArrayList<>();
						List<Linha> blocoCompleto = new ArrayList<>();
						List<Linha> blocoCompleto_temp = new ArrayList<>();
						listaMinY = new ArrayList<>();
						int numeroLinhasBloco2 = 0; 
						List<List<Linha>> bloco2_new = new ArrayList<>();
						List<Linha> bloco2_new_temp = new ArrayList<>();

						//System.out.println(page); //#controle
						//System.out.println("b1: " + " camadas = " + bloco1_temp.size() + "; tamanho = " + bloco1.size()); //#controle
						
						//System.out.println(" ----------------- BLOCO 2 -----------------------");						
						
						//System.out.println(bloco2.size()); //#controle
						
						for (int j = 0; j <= bloco2.size() - 1; ++j) {
							List<Linha> temp = new ArrayList<>();								
							temp.addAll(bloco2.get(j));
							//System.out.println(" > " + temp.size());
							for (int k = 0; k <= temp.size() - 1; k++)
							{
								//System.out.println(bloco2.get(j).get(k).texto);
								//System.out.println(temp.get(k).texto);
								//System.out.println(temp.get(k).endY);
							}
						}							

						
						//System.out.println(bloco2.get(0).size());
						//System.out.println(bloco2.get(1).size());
						//System.out.println(bloco2.get(2).size());
						
						if (bloco2.size() > 0) {
							
							//Map<Float, List<Linha>> dictionary2 = new HashMap<Float, List<Linha>>();	
							//boolean pular = false;
							if (bloco2.size() > 1) {
								for (int j = 0; j <= bloco2.size() - 1; ++j) {
									//if (pular) {
									//	pular = false;
									//	continue;										
									//}
									
									//System.out.println("size: " + bloco2.get(j).size());
									
									
									bloco2_temp = new ArrayList<>();				
									bloco2_temp.addAll(bloco2.get(j));
				
									if (j == 0) {
										minY = Collections.min(bloco2_temp, Comparator.comparing(c -> c.getY())).endY;
										//System.out.println(minY);
										maxY = Collections.max(bloco2_temp, Comparator.comparing(c -> c.getY())).endY;
										bloco2_new.add(bloco2_temp);
										//System.out.println(maxY);
									} else {
										if (minY < Collections.max(bloco2_temp, Comparator.comparing(c -> c.getY())).endY && maxY > Collections.min(bloco2_temp, Comparator.comparing(c -> c.getY())).endY) {
											//bloco2_new.remove(j-1);
											//System.out.println("TEM INTERSEÇÃO COMPLETA ENTRE O ELEMENTO " + j + " COM O " + (j - 1));
											//System.out.println(minY);
											//System.out.println(maxY);											
											//System.out.println("qual o j " + j);
											//System.out.println(Collections.min(bloco2_temp, Comparator.comparing(c -> c.getY())).endY);
											//System.out.println(Collections.max(bloco2_temp, Comparator.comparing(c -> c.getY())).endY);											
											
									    	//List<Float> a = new ArrayList<>();
									    	//a.add((float) minY);
									    	//a.add((float) maxY);      	
									    	//List<Float> b = new ArrayList<>();
									    	//b.add((float) Collections.min(bloco2_temp, Comparator.comparing(c -> c.getY())).endY);
									    	//b.add((float) Collections.max(bloco2_temp, Comparator.comparing(c -> c.getY())).endY);
									  	
											minY = Math.max(minY, Collections.min(bloco2_temp, Comparator.comparing(c -> c.getY())).endY);
											maxY = Math.min(maxY, Collections.max(bloco2_temp, Comparator.comparing(c -> c.getY())).endY);
											//System.out.println(minY);
											//System.out.println(maxY);
											
											if (bloco2.get(j).size() > bloco2.get(j - 1).size()) {
												
												if (j - 1 < bloco2_new.size()) {
													bloco2_new.remove(j - 1);
												}
												bloco2_temp = new ArrayList<>();
												
												List<Float> listaDistanciaY = new ArrayList<>();
												int elementoAntecedente = 0;
												for (int k = 0; k <= bloco2.get(j).size() - 1; ++k) {
													//dicionario.put(listaLinhas.get(k).endY - y_atual,k);
													listaDistanciaY.add(bloco2.get(j).get(k).endY - minY);
													//contadorElementosBloco = contadorElementosBloco + 1;
												}
												
												Collections.sort(listaDistanciaY);
												
												for (int k = 0; k <= listaDistanciaY.size() - 1; ++k) {					
													if (listaDistanciaY.get(k) >= 0) {						
														elementoAntecedente = k - 1;
														break;
													}	
												}		
												
												for (int k = 0; k <= elementoAntecedente; ++k) {
													//dicionario.put(listaLinhas.get(k).endY - y_atual,k);
													//elementoAntecedente
													//System.out.println(bloco2.get(j - 1).get(k).texto);
													bloco2_temp.add(bloco2.get(j).get(k));
													//contadorElementosBloco = contadorElementosBloco + 1;
												}		
												
												//System.out.println("size: " + bloco2.get(j +1).size());
												//System.out.println("size: " + bloco2.get(j).size());
												//System.out.println("size: " + bloco2.get(j - 1).size());
												
												for (int k = 0; k <= bloco2.get(j - 1).size() - 1; ++k) {
													//dicionario.put(listaLinhas.get(k).endY - y_atual,k);
													//elementoAntecedente
													//System.out.println(bloco2.get(j).get(k).texto);
													//System.out.println(bloco2.get(j).get(k).endY);
													bloco2_temp.add(bloco2.get(j - 1).get(k));
													//contadorElementosBloco = contadorElementosBloco + 1;
												}	
														
												
												//bloco2_temp.addAll(bloco2.get(j));
												
												for (int k = elementoAntecedente + 1; k <= bloco2.get(j).size() - 1; ++k) {
													//dicionario.put(listaLinhas.get(k).endY - y_atual,k);
													//elementoAntecedente
													//System.out.println(bloco2.get(j - 1).get(k).texto);
													bloco2_temp.add(bloco2.get(j).get(k));
													//contadorElementosBloco = contadorElementosBloco + 1;
												}												
												
												
												//System.out.println(elementoAntecedente);
												//System.out.println(bloco2_temp.get(elementoAntecedente).texto);
												//System.out.println(bloco2_temp.get(elementoAntecedente).endY);
												
												
											} else {												
												if (j - 1 < bloco2_new.size()) {
													bloco2_new.remove(j - 1);
												}
												//System.out.println(j);
												//System.out.println(bloco2_new.size());
												//System.out.println(j - 1 < bloco2_new.size());
												//bloco2_new.remove(j - 1);
												bloco2_temp = new ArrayList<>();
												
												List<Float> listaDistanciaY = new ArrayList<>();
												int elementoAntecedente = 0;
												for (int k = 0; k <= bloco2.get(j - 1).size() - 1; ++k) {
													//dicionario.put(listaLinhas.get(k).endY - y_atual,k);
													listaDistanciaY.add(bloco2.get(j - 1).get(k).endY - minY);
													//contadorElementosBloco = contadorElementosBloco + 1;
												}
												
												Collections.sort(listaDistanciaY);
												
												for (int k = 0; k <= listaDistanciaY.size() - 1; ++k) {					
													if (listaDistanciaY.get(k) > 0) {						
														elementoAntecedente = k - 1;
														break;
													}	
												}		
												
												//System.out.println(elementoAntecedente);
												//System.out.println(bloco2.get(j - 1).get(elementoAntecedente).texto);
												//System.out.println(bloco2.get(j - 1).get(elementoAntecedente).endY);
												
												//bloco2_temp = new ArrayList<>();
												
												for (int k = 0; k <= elementoAntecedente; ++k) {
													//dicionario.put(listaLinhas.get(k).endY - y_atual,k);
													//elementoAntecedente
													//System.out.println(bloco2.get(j - 1).get(k).texto);
													bloco2_temp.add(bloco2.get(j - 1).get(k));
													//contadorElementosBloco = contadorElementosBloco + 1;
												}		
												
												//System.out.println("size: " + bloco2.get(j +1).size());
												//System.out.println("size: " + bloco2.get(j).size());
												//System.out.println("size: " + bloco2.get(j - 1).size());
												
												for (int k = 0; k <= bloco2.get(j).size() - 1; ++k) {
													//dicionario.put(listaLinhas.get(k).endY - y_atual,k);
													//elementoAntecedente
													//System.out.println(bloco2.get(j).get(k).texto);
													//System.out.println(bloco2.get(j).get(k).endY);
													bloco2_temp.add(bloco2.get(j).get(k));
													//contadorElementosBloco = contadorElementosBloco + 1;
												}	
														
												
												//bloco2_temp.addAll(bloco2.get(j));
												
												for (int k = elementoAntecedente + 1; k <= bloco2.get(j - 1).size() - 1; ++k) {
													//dicionario.put(listaLinhas.get(k).endY - y_atual,k);
													//elementoAntecedente
													//System.out.println(bloco2.get(j - 1).get(k).texto);
													bloco2_temp.add(bloco2.get(j - 1).get(k));
													//contadorElementosBloco = contadorElementosBloco + 1;
												}													
												
												//bloco2_new.add(bloco2_new_temp);
												//j = j + 1;
												//pular = true;
												//continue;
												
											}
					
											//} else if (minY < Collections.max(bloco2_temp, Comparator.comparing(c -> c.getY())).endY && maxY < Collections.min(bloco2_temp, Comparator.comparing(c -> c.getY())).endY) {
										//	System.out.println("TEM INTERSEÇÃO BAIXO Y ENTRE O ELEMENTO " + j + " COM O " + (j - 1));
											//System.out.println(minY);
											//System.out.println(minY);
										//} else if (maxY > Collections.min(bloco2_temp, Comparator.comparing(c -> c.getY())).endY && minY > Collections.max(bloco2_temp, Comparator.comparing(c -> c.getY())).endY ) {
											//System.out.println("TEM INTERSEÇÃO ALTO Y ENTRE O ELEMENTO " + j + " COM O " + (j - 1));
										}
										bloco2_new.add(bloco2_temp);
										minY = Collections.min(bloco2_temp, Comparator.comparing(c -> c.getY())).endY;
										maxY = Collections.max(bloco2_temp, Comparator.comparing(c -> c.getY())).endY;	
									}
									

				
									
								}										
								
							} else {
								bloco2_new.addAll(bloco2);
							}
							
							
							for (int j = 0; j <= bloco2_new.size() - 1; ++j) {
								List<Linha> temp = new ArrayList<>();								
								temp.addAll(bloco2_new.get(j));
								//System.out.println(" > " + temp.size());
								for (int k = 0; k <= temp.size() - 1; k++)
								{
									//System.out.println(temp.get(k).texto);
									//System.out.println(temp.get(k).endY);
								}
							}							
							
							

							
							
							maxAnterior = 70;
							//maxAnterior = 69;
							maxY = 80;
							minY = 80;

							dictionary = new HashMap<Float, List<Linha>>();	

							
							
							//bloco2 = new ArrayList<>();
							//bloco2 = bloco2_new;
							
							
							for (int j = 0; j <= bloco2_new.size() - 1; ++j) {
								bloco2_temp = new ArrayList<>();
								bloco2_temp = bloco2_new.get(j);
								//bloco2_temp.addAll(bloco2_new.get(j));
								DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
								for (int k = 0; k <= bloco2_temp.size() - 1; k++) {																		
									descriptiveStatistics.addValue(bloco2_temp.get(k).endY);									
								}
								
								

								//Collections.sort(bloco2_temp, Comparator.comparing(s -> s.getY()));
								numeroLinhasBloco2 = numeroLinhasBloco2 + bloco2_temp.size();
								//System.out.println(bloco2_temp.get(j).texto);
								// float maxY = Collections.max(bloco2_temp, Comparator.comparing(c ->
								// c.getY())).endY;
								minY = (float) descriptiveStatistics.getPercentile(50);
																
								//minY = Collections.min(bloco2_temp, Comparator.comparing(c -> c.getY())).endY;
								dictionary.put(minY, bloco2_temp);
								listaMinY.add(minY);
							}

							//System.out.println(numeroLinhasBloco2); //#controle
							
							//System.out.println("b2: " + " camadas = " + bloco2.size() + "; tamanho = " + numeroLinhasBloco2); //#controle
							
							//if (bloco1_temp.size() > 1 || bloco2.size() > 1) {
								//System.out.println(page); //#controle
								//System.out.println("b1: " + " camadas = " + bloco1_temp.size() + "; tamanho = " + bloco1.size()); //#controle
								//System.out.println("b2: " + " camadas = " + bloco2.size() + "; tamanho = " + numeroLinhasBloco2); //#controle
							//}
							
							Collections.sort(listaMinY);
							
							//System.out.println(listaMinY);

							bloco2Final = new ArrayList<>();

							for (int j = 0; j <= listaMinY.size() - 1; ++j) {
								bloco2Final.add(dictionary.get(listaMinY.get(j)));
							}
							
							
							
							

							//bloco2Final = new ArrayList<>();
							
							for (int j = 0; j <= bloco2_new.size() - 1; ++j) {
								//bloco2_temp = new ArrayList<>();
								//bloco2_temp.addAll(bloco2.get(j));								
								//bloco2Final.add(bloco2_new.get(j));
							}							
							
							
							//bloco2Final.addAll(bloco2_new);
							
							for (int j = 0; j <= bloco2Final.size() - 1; ++j) {
								List<Linha> temp = new ArrayList<>();								
								temp.addAll(bloco2Final.get(j));
								//System.out.println(" > " + temp.size());
								for (int k = 0; k <= temp.size() - 1; k++)
								{
									//System.out.println(temp.get(k).texto);
									//System.out.println(temp.get(k).endY);
								}
							}							
							

							// bloco2 = new ArrayList<>();
							// bloco2 = bloco2Novo;
							
							//bloco2Final = bloco2_new;

							for (int j = 0; j <= bloco2Final.size() - 1; ++j) {

								boolean existeBlocoUnico_temp = false;
								bloco2_temp = new ArrayList<>();
								//bloco2_temp = bloco2Final.get(j);
								bloco2_temp.addAll(bloco2Final.get(j));
								maxY = Collections.max(bloco2_temp, Comparator.comparing(c -> c.getY())).endY;
								minY = Collections.min(bloco2_temp, Comparator.comparing(c -> c.getY())).endY;

								if (j == 0) {
									if (minY < 120) {
										minY = 80;
									}									
								}

								
								if (j == bloco2Final.size() - 1) {
									if (maxY > 860) {
										maxY = 880;
									}								
								}								
								

								
								//System.out.println(minY);
								//System.out.println(maxY);		
								//System.out.println(maxAnterior);	
								
								if (minY < maxAnterior) {
									for (int k = 0; k <= bloco2_temp.size() - 1; ++k) {
										bloco2_temp.get(k).setPageNumber(page);
										bloco2_temp.get(k).setBloco("Bloco2");
										bloco2_temp.get(k).setNumeroDODF(numero_DODF);
										bloco2_temp.get(k).setDataDODF(data_DODF);							
										blocoCompleto_temp.add(bloco2_temp.get(k));
										//System.out.println(bloco2_temp.get(k).texto);		
										maxY = maxAnterior;
									}
									//System.out.println("saiu fora"); //#controle
									continue;
								}	
								
								if (minY - maxAnterior < 100 && minY - maxAnterior > 0) {
								//if (minY - maxAnterior < 100) {
									minY = maxAnterior + (float) 10.000000000000001;
								}
								
								//System.out.println(minY); //#controle
								//System.out.println(maxY);	//#controle	
								//System.out.println(maxAnterior); //#controle								
							
								for (int k = 0; k <= bloco1.size() - 1; ++k) {
									//if (bloco1.get(k).endY > maxAnterior + 5 && bloco1.get(k).endY < minY - 5 &&  minY - maxAnterior > 100) {
									if (bloco1.get(k).endY > maxAnterior + 5 && bloco1.get(k).endY < minY - 5 &&  minY - maxAnterior > 100) {										
										bloco1.get(k).setBloco("BlocoUnico");
										bloco1.get(k).setNumeroDODF(numero_DODF);
										bloco1.get(k).setDataDODF(data_DODF);
										blocoCompleto_temp.add(bloco1.get(k));
										//System.out.println(bloco1.get(k).texto); //#controle
										existeBlocoUnico_temp = true;
										existeBlocoUnico = true;
									}
								}

								for (int k = 0; k <= bloco1.size() - 1; ++k) {
									if (bloco1.get(k).startX >= 40 && bloco1.get(k).endX <= 415
											&& bloco1.get(k).endY >= minY - 5 && bloco1.get(k).endY <= maxY + 5) {
										bloco1.get(k).setBloco("Bloco1");
										bloco1.get(k).setNumeroDODF(numero_DODF);
										bloco1.get(k).setDataDODF(data_DODF);								
										blocoCompleto_temp.add(bloco1.get(k));
										//System.out.println(bloco1.get(k).texto); //#controle
										//System.out.println(bloco1.get(k).endY);
									}
								}

								for (int k = 0; k <= bloco2_temp.size() - 1; ++k) {
									bloco2_temp.get(k).setPageNumber(page);
									bloco2_temp.get(k).setBloco("Bloco2");
									bloco2_temp.get(k).setNumeroDODF(numero_DODF);
									bloco2_temp.get(k).setDataDODF(data_DODF);							
									blocoCompleto_temp.add(bloco2_temp.get(k));
									//System.out.println(bloco2_temp.get(k).texto); //#controle
								}

								maxAnterior = maxY;
							
								//Collections.sort(bloco2Final, Comparator.comparing(s -> s.getY()));
							
								//if (existeBlocoUnico == true) {							
								//	blocoCompleto.addAll(blocoCompleto_temp);
								//} else {
								//	bloco_1e2.addAll(blocoCompleto_temp);
								//	
								//}
								if (maxY > 850) {
									//break;
								}							
								
								if (existeBlocoUnico_temp) {
									//List<Float> mediaBlocoUnico = new ArrayList<>();
									//List<Float> mediaBloco1 = new ArrayList<>();
									//List<Float> mediaBloco2 = new ArrayList<>();
									for (int k = 0; k <= blocoCompleto_temp.size() - 1; ++k) {
										//if (blocoCompleto_temp > )

										//blocoCompleto_temp
									}									
								}									
															
								
							}
							
							
							
							for (int k = 0; k <= blocoCompleto_temp.size() - 1; ++k) {
								//System.out.println(blocoCompleto_temp.get(k).texto);
							}
													
							for (int k = 0; k <= blocoCompleto_temp.size() - 1; ++k) {
								if (blocoCompleto_temp.get(k).TipoBloco == "Bloco1" || blocoCompleto_temp.get(k).TipoBloco == "Bloco2") {
								//if (bloco1.get(k).endY >= 80 && bloco1.get(k).endY <= 880) {											
									bloco_1e2.add(blocoCompleto_temp.get(k));
								} else {
									if (bloco_1e2.isEmpty() == false) {
										Collections.sort(bloco_1e2, Comparator.comparing(s -> s.getTipoBloco()));
										blocoCompleto.addAll(bloco_1e2);
										bloco_1e2  = new ArrayList<>();
										existeBlocoUnico = true;
									} 
									blocoCompleto.add(blocoCompleto_temp.get(k));										
									//continue;
								}

							}
							
							if (bloco_1e2.isEmpty() == false) {
								//Collections.sort(bloco_1e2, Comparator.comparing(s -> s.getX()));
								//Collections.sort(bloco_1e2, Comparator.comparing(s -> s.getY()));
								//Collections.sort(bloco_1e2, Comparator.comparing(s -> s.getTipoBloco()));
								Collections.sort(bloco_1e2, Comparator.comparing(s -> s.getTipoBloco()));
								blocoCompleto.addAll(bloco_1e2);
							} 								
								
							
							if (maxY < 800) {
								List<Linha> blocoTeste = new ArrayList<>();
								//Collections.sort(blocoCompleto_temp, Comparator.comparing(s -> s.getTipoBloco()));
								for (int k = 0; k <= bloco1.size() - 1; ++k) {
									if (bloco1.get(k).endY > maxY + 5) {
									//if (bloco1.get(k).endY >= 80 && bloco1.get(k).endY <= 880) {										
										//bloco1.get(k).setBloco("BlocoUnico");
										//bloco1.get(k).setNumeroDODF(numero_DODF);
										//bloco1.get(k).setDataDODF(data_DODF);
										blocoTeste.add(bloco1.get(k));
										//System.out.println(bloco1.get(k).texto);
										//existeBlocoUnico = true;
									}
								}
								
								if (verificaBlocoUnico(blocoTeste)) {
									
									for (int k = 0; k <= bloco1.size() - 1; ++k) {
										if (bloco1.get(k).endY > maxY + 5) {
										//if (bloco1.get(k).endY >= 80 && bloco1.get(k).endY <= 880) {										
											bloco1.get(k).setBloco("BlocoUnico");
											bloco1.get(k).setNumeroDODF(numero_DODF);
											bloco1.get(k).setDataDODF(data_DODF);	
											blocoCompleto.add(bloco1.get(k));
											//System.out.println(bloco1.get(k).texto);
											//existeBlocoUnico = true;
										}
									}
									
									existeBlocoUnico = true;
									
								} else {
									
									for (int k = 0; k <= bloco1.size() - 1; ++k) {
										if (bloco1.get(k).endY > maxY + 5) {
										//if (bloco1.get(k).endY >= 80 && bloco1.get(k).endY <= 880) {										
											bloco1.get(k).setBloco("Bloco1");
											bloco1.get(k).setNumeroDODF(numero_DODF);
											bloco1.get(k).setDataDODF(data_DODF);	
											blocoCompleto.add(bloco1.get(k));
											//System.out.println(bloco1.get(k).texto);
											//existeBlocoUnico = true;
										}
									}									
								}
								
							} 
							
							
							
							//System.out.println(bloco1.size()/numeroLinhasBloco2);
							//System.out.println(bloco1.size());
							//System.out.println(numeroLinhasBloco2);							
							
							//quem asabe aqui... 
							//verificar 
							//pendente
						existeBlocoUnico = false;
							
							for (int k = 0; k <= blocoCompleto.size() - 1; ++k) {
								if (blocoCompleto.get(k).endY >= 80 
										&& blocoCompleto.get(k).endY <= 880 
										&& (blocoCompleto.get(k).endX - blocoCompleto.get(k).startX > 355
										|| blocoCompleto.get(k).startX <= 405 && blocoCompleto.get(k).endX >= 415)) {
									//bloco1.get(k).setBloco("BlocoUnico");
									//bloco1.get(k).setNumeroDODF(numero_DODF);
									//bloco1.get(k).setDataDODF(data_DODF);
									//blocoCompleto_temp.add(bloco1.get(k));
									//System.out.println("entrei aqui!!!");
									//System.out.println(bloco1.get(k).texto);
									existeBlocoUnico = true;									
								}
							}							
								

							//int contadorBloco1 = 0;
							//int contadorBlocoUnico = 0;
							
							
							if (existeBlocoUnico == false) {
							
								List<Float> testeBlocoUnico = new ArrayList<>();
								List<Float> larguraTexto = new ArrayList<>();
								
								for (int k = 0; k <= blocoCompleto.size() - 1; ++k) {
									if (blocoCompleto.get(k).TipoBloco == "BlocoUnico") {
										//existeBlocoUnico = true;	
										testeBlocoUnico.add(blocoCompleto.get(k).endY);
										larguraTexto.add(blocoCompleto.get(k).endX - blocoCompleto.get(k).startX);
									}
								}
							
							
								List<Integer> listaFreqBlocoUnico = new ArrayList<>();
								
								Map<Integer, Float> dicionarioFrequencia = new HashMap<Integer, Float>();			
						        Set<Float> st = new HashSet<Float>(testeBlocoUnico); 
						        for (Float s : st)	 {
						        	int frequencia = Collections.frequency(testeBlocoUnico, s);	           	
						        	listaFreqBlocoUnico.add(frequencia);
						        	dicionarioFrequencia.put(frequencia, s);	                	
						        }    
								
						        Float elementoLarguraMaior = (float) 0;
						        int freqMaior = 0;
						        
						        if (larguraTexto.isEmpty() == false)						        
						        	elementoLarguraMaior = Collections.max(larguraTexto);
					        	
						        if (larguraTexto.isEmpty() == false)						        
						        	freqMaior = Collections.max(listaFreqBlocoUnico);						        
						        
						        
					        	//System.out.println(elementoLarguraMaior);
					        	//System.out.println(Collections.max(larguraTexto));
						        //System.out.println(Collections.max(listaFreqBlocoUnico));
						        
						        if (freqMaior > 1 || elementoLarguraMaior > 355) {
						        	existeBlocoUnico = true;
						        } else {
						        	existeBlocoUnico = false;
						        }								
								
							}

							
							//System.out.println(contadorBloco1);
							//System.out.println(contadorBlocoUnico);
							
							if (existeBlocoUnico == false) {

								for (int k = 0; k <= blocoCompleto.size() - 1; ++k) {
									if (blocoCompleto.get(k).startX >= 40 && blocoCompleto.get(k).startX < 415
							        		&& blocoCompleto.get(k).endX <= 415
							        		&& blocoCompleto.get(k).endY >= 80
											&& blocoCompleto.get(k).endY <= 880  ) {
										blocoCompleto.get(k).setBloco("Bloco1");																									
									}							
									else if (blocoCompleto.get(k).startX >= 415 && blocoCompleto.get(k).endX > 415
							        		&& blocoCompleto.get(k).endY >= 80
											&& blocoCompleto.get(k).endY <= 880  ) {
										blocoCompleto.get(k).setBloco("Bloco2");
																								
									}	
								}	
												
								
							}							
							
							
						} else {							
							
							existeBlocoUnico = false;
							
							for (int k = 0; k <= bloco1.size() - 1; ++k) {
								if (bloco1.get(k).endY >= 80 
										&& bloco1.get(k).endY <= 880 
										&& (bloco1.get(k).endX - bloco1.get(k).startX > 355
										|| bloco1.get(k).startX <= 405 && bloco1.get(k).endX >= 415)) {
									//bloco1.get(k).setBloco("BlocoUnico");
									//bloco1.get(k).setNumeroDODF(numero_DODF);
									//bloco1.get(k).setDataDODF(data_DODF);
									//blocoCompleto_temp.add(bloco1.get(k));
									//System.out.println("entrei aqui!!!");
									//System.out.println(bloco1.get(k).texto);
									existeBlocoUnico = true;									
								}
							}
															
							
							
							if (existeBlocoUnico == false) {
								
								List<Float> testeBlocoUnico = new ArrayList<>();
								List<Float> larguraTexto = new ArrayList<>();
								
								for (int k = 0; k <= bloco1.size() - 1; ++k) {
									if (bloco1.get(k).TipoBloco == "BlocoUnico") {
										//existeBlocoUnico = true;	
										testeBlocoUnico.add(bloco1.get(k).endY);
										larguraTexto.add(bloco1.get(k).endX - bloco1.get(k).startX);
									}
								}
							
							
								List<Integer> listaFreqBlocoUnico = new ArrayList<>();
								
								Map<Integer, Float> dicionarioFrequencia = new HashMap<Integer, Float>();			
						        Set<Float> st = new HashSet<Float>(testeBlocoUnico); 
						        for (Float s : st)	 {
						        	int frequencia = Collections.frequency(testeBlocoUnico, s);	           	
						        	listaFreqBlocoUnico.add(frequencia);
						        	dicionarioFrequencia.put(frequencia, s);	                	
						        }    
								
						        Float elementoLarguraMaior = (float) 0;
						        int freqMaior = 0;
						        
						        if (larguraTexto.isEmpty() == false)						        
						        	elementoLarguraMaior = Collections.max(larguraTexto);
					        	
						        if (larguraTexto.isEmpty() == false)						        
						        	freqMaior = Collections.max(listaFreqBlocoUnico);						        
						        
						        
					        	//System.out.println(elementoLarguraMaior);
					        	//System.out.println(Collections.max(larguraTexto));
						        //System.out.println(Collections.max(listaFreqBlocoUnico));
						        
						        if (freqMaior > 1 || elementoLarguraMaior > 355) {
						        	existeBlocoUnico = true;
						        } else {
						        	existeBlocoUnico = false;
						        }								
								
							}
							

							
							if (existeBlocoUnico) {
								
								for (int k = 0; k <= bloco1.size() - 1; ++k) {
									if (bloco1.get(k).endY >= 80 && bloco1.get(k).endY <= 880 ) {
										bloco1.get(k).setBloco("BlocoUnico");
										bloco1.get(k).setNumeroDODF(numero_DODF);
										bloco1.get(k).setDataDODF(data_DODF);
										blocoCompleto_temp.add(bloco1.get(k));
										//System.out.println(bloco1.get(k).texto);
										existeBlocoUnico = true;
										
									}
								}
								
								blocoCompleto.addAll(blocoCompleto_temp);

								
							} else {								
								
								for (int k = 0; k <= bloco1.size() - 1; ++k) {
									if (bloco1.get(k).startX >= 40 && bloco1.get(k).startX < 415
							        		&& bloco1.get(k).endX <= 415
							        		&& bloco1.get(k).endY >= 80
											&& bloco1.get(k).endY <= 880  ) {
										bloco1.get(k).setBloco("Bloco1");
										bloco1.get(k).setNumeroDODF(numero_DODF);
										bloco1.get(k).setDataDODF(data_DODF);								
										blocoCompleto_temp.add(bloco1.get(k));																										
									}							
									else if (bloco1.get(k).startX >= 415 && bloco1.get(k).endX > 415
							        		&& bloco1.get(k).endY >= 80
											&& bloco1.get(k).endY <= 880  ) {
										bloco1.get(k).setBloco("Bloco2");
										bloco1.get(k).setNumeroDODF(numero_DODF);
										bloco1.get(k).setDataDODF(data_DODF);								
										blocoCompleto_temp.add(bloco1.get(k));																										
									}	
								}	
								
								blocoCompleto.addAll(blocoCompleto_temp);

							}
						}
							
						
						//System.out.println(page); //#controle
						//System.out.println("b1: " + " camadas = " + bloco1_temp.size() + "; tamanho = " + bloco1.size()); //#controle
						//System.out.println("b2: " + " camadas = " + bloco2.size() + "; tamanho = " + numeroLinhasBloco2); //#controle
						
	
						
						
						for (int j = 0; j <= blocoCompleto.size() - 1; ++j) {
							//System.out.println(blocoCompleto.get(j).texto); //Bloco Completo: Resultado da estrutura da pagina do DODF #controle
						}						
						
						if (existeBlocoUnico == true) {
							System.out.println("Bloco Único na página :" + page);	
							//Collections.sort(blocoCompleto, Comparator.comparing(s -> s.getTipoBloco()));
						} else {
							Collections.sort(blocoCompleto, Comparator.comparing(s -> s.getTipoBloco()));
						}
						
						//List<Linha> blocoCompletoFinal2 = new ArrayList<>();

						/*
						
						List<Linha> blocoCompletoFinal = new ArrayList<>();
						
						
						//blocoCompletoFinal.addAll(blocoCompleto);
						
						for (int j = 0; j <= blocoCompleto.size() - 1; ++j) {
							registroElemento =  blocoCompleto.get(j);
							
							int elementoAntecedente = 0;							
							elementoAntecedente = existeBlocoFlutuante(registroElemento, blocoCompletoFinal, true);							
							blocoCompletoFinal.add(elementoAntecedente, registroElemento);
							
							//if (elementoAntecedente < contaElementosFlutuantes) {
								//contaElementosFlutuantes = contaElementosFlutuantes - 1;
							//}
							//contaElementosFlutuantes = contaElementosFlutuantes + 1;
						}				
						
						*/
						
						List<Linha> blocoCompletoFinal = new ArrayList<>();
						//List<Linha> blocoCompletoFinal2 = new ArrayList<>();
						List<Integer> removerElementos = new ArrayList<>();
						blocoCompletoFinal.addAll(blocoCompleto);
						//blocoCompletoFinal2.addAll(blocoCompleto);
						
						int contaElementosFlutuantes = 0;
						//int fimCiclo = blocoCompletoFinal.size() - 1;
						
						
						for (int j = 0; j <= blocoCompletoFinal.size() - 1; ++j) {
							registroElemento =  blocoCompletoFinal.get(j);
							//System.out.println("j: " + j);
							//System.out.println("registroElemento.texto: " + registroElemento.texto);
							int elementoAntecedente = 0;							
							elementoAntecedente = existeBlocoFlutuante2(j, registroElemento, blocoCompletoFinal, true);							
							if (elementoAntecedente == j) {
								//blocoCompletoFinal.add(registroElemento);								
								//System.out.println("elementoAntecedente != j :" + elementoAntecedente);
							} else {
								blocoCompletoFinal.remove(j);
								blocoCompletoFinal.add(elementoAntecedente, registroElemento); //verificar isso
								j = - 1;													
							}
														
							
							//contaElementosFlutuantes = contaElementosFlutuantes + 1;
						}	
						
						//removerElementos.sort(c);
						Collections.sort(removerElementos, Collections.reverseOrder());
						
						//for (int j = 0; j <= removerElementos.size() - 1; ++j) {
							//blocoCompletoFinal2.remove(removerElementos.get(j).intValue());
							//System.out.println("remover " + blocoCompletoFinal.get(j).texto); //Bloco Completo Final: Acrescente ao resultado da estrutura da pagina do DODF o ajuste de elemntos flutuantes#controle
						//}							

						

						//for (int j = 0; j <= blocoCompletoFinal.size() - 1; ++j) {
							//blocoCompletoFinal.get(j).setNumeroLinha(j + 1);
							//System.out.println(blocoCompletoFinal.get(j).texto); //Bloco Completo Final: Acrescente ao resultado da estrutura da pagina do DODF o ajuste de elemntos flutuantes#controle
						//}								
						
						
						//boolean addElement = false;
						
						
						for (int j = 0; j <= blocoCompletoFinal.size() - 1; ++j) {
							if (blocoCompletoFinal.get(j).endFontFamily.contains("Bold") && blocoCompletoFinal.get(j).texto.equals("INEDITORIAIS")) {
								//System.out.println("achou");
								break outloop;
							} else {				
								blocoCompletoFinal.get(j).setNumeroLinha(j + 1);
								textocompletoFinal.add(blocoCompletoFinal.get(j));
							}
						}		
						
						
						//textocompletoFinal.addAll(blocoCompleto);
																			
						//blocoCompletoFinal2.add(registroElemento);
						//blocoCompletoFinal2.add(149, registroElemento);
						//blocoCompletoFinal2.add(registroElemento);
						
						//textocompletoFinal.addAll(blocoCompletoFinal);
		 


				}

				//exportDataToExcel(textocompletoFinal, file);
				if (secao == true) {
					PDPage pageElement = document.getPage(p);				
					SaveImagesInPdf2 extractor = new SaveImagesInPdf2(pageElement, page, contadorImagens, fileName);				
					extractor.run();					
				}

				
				
			}
			
			//double[] x = null;
			//org.apache.commons.math3.stat.StatUtils.mode(x);
			
			//Collections.frequency(listaNumeroDODF, s);

	        if (listaDataDODF.isEmpty() == false) {
	        	String dataDODF = confirmaDataDODF(listaDataDODF);	    
				for (int k = 0; k <= textocompletoFinal.size() - 1; ++k) {
					textocompletoFinal.get(k).setDataDODF(dataDODF);
				}	        	 
	        	 
	        }
	        
	        if (listaNumeroDODF.isEmpty() == false) {
	        	int numeroDODF = confirmaNumeroDODF(listaNumeroDODF);
				for (int k = 0; k <= textocompletoFinal.size() - 1; ++k) {
					textocompletoFinal.get(k).setNumeroDODF(numeroDODF);
				}	        	
	        }

	        //System.out.println("empyty??? " + listaComplementoDODF.isEmpty());
	        
	        if (listaComplementoDODF.isEmpty() == false) {
	        	String complemento = confirmaComplementoDODF(listaComplementoDODF);
				for (int k = 0; k <= textocompletoFinal.size() - 1; ++k) {
					textocompletoFinal.get(k).setComplemento(complemento);
				}	        	
	        } else {
				for (int k = 0; k <= textocompletoFinal.size() - 1; ++k) {
					textocompletoFinal.get(k).setComplemento("INTEGRA");
				}	    	        	
	        }     
	        
	        List<Linha> listaFinal = new ArrayList<>();
	        
	        boolean primeiroElementoSecao = false;
	        int contadorElemento = 0;
	        
			for (int k = 0; k <= textocompletoFinal.size() - 1; ++k) {
				if (textocompletoFinal.get(k).endFontFamily.contains("Bold") && textocompletoFinal.get(k).texto.equals("INEDITORIAIS")) {
					//System.out.println("achou ------------------------------>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					//textocompletoFinal.get(k).setNumeroLinhaGeral(k + 1);
					//listaFinal.add(textocompletoFinal.get(k));					
					break;
				} else {
					
					//contadorElemento = contadorElemento + 1;
					//textocompletoFinal.get(k).setNumeroLinhaGeral(contadorElemento);
					//listaFinal.add(textocompletoFinal.get(k));
					
					
					if (primeiroElementoSecao == false && listaFinal.isEmpty()) {
						
						if (textocompletoFinal.get(k).endFontFamily.contains("Bold") && textocompletoFinal.get(k).fontSizePT == 12) {

							//Pattern p = Pattern.compile("SE[Ç]C[ÃA]O II[I1l]|SE[Ç]C[ÃA]O I[I1l]");
							Pattern p1 = Pattern.compile("SE[ÇC][ÃA]O I[I1l]|SE[ÇC][ÃA]O II[I1l]");
							Matcher m1 = p1.matcher(textocompletoFinal.get(k).texto);

							if (m1.find()) {
								//System.out.println(textocompletoFinal.get(k).texto + " localizada na página " + page); //#controle
								primeiroElementoSecao = true;
								//System.out.println("achou");
								contadorElemento = contadorElemento + 1;
								textocompletoFinal.get(k).setNumeroLinhaGeral(contadorElemento);
								listaFinal.add(textocompletoFinal.get(k));
							}
						}							
						
					} else if (listaFinal.isEmpty() == false) {
						contadorElemento = contadorElemento + 1;
						textocompletoFinal.get(k).setNumeroLinhaGeral(contadorElemento);
						listaFinal.add(textocompletoFinal.get(k));
					}
					
					

					
					

				}
			}		 
			
						
			
			exportDataToExcel(listaFinal, file);
			exportDataToBD(listaFinal);
			
			

		} finally {
			if (document != null) {
				document.close();
			}
		}
	}



	private static boolean verificaBlocoUnico(List<Linha> testeBlocoUnico) {

		  
		  //System.out.println("verificaBlocoUnico");

			
		  for (int k = 0; k <= testeBlocoUnico.size() - 1; ++k) {
			  //System.out.println(testeBlocoUnico.get(k).texto + " " + testeBlocoUnico.get(k).endY);
		  }    
		  		
		
		 //List<Linha> bloco1_temp = new ArrayList<>();
		 //List<Linha> bloco2_temp = new ArrayList<>();
		 
		 boolean existeBlocoUnico = false;
		 
		 List<Float> bloco1Y = new ArrayList<>();
		 List<Float> bloco2Y = new ArrayList<>();
		 List<Float> blocoCompletoY = new ArrayList<>();
		 
		 for (int k = 0; k <= testeBlocoUnico.size() - 1; ++k) {
		  if (testeBlocoUnico.get(k).endY >= 80 
		    && testeBlocoUnico.get(k).endY <= 880 
		    && (testeBlocoUnico.get(k).endX - testeBlocoUnico.get(k).startX > 355
		    || testeBlocoUnico.get(k).startX <= 405 && testeBlocoUnico.get(k).endX >= 415)) {
		   //bloco1.get(k).setBloco("BlocoUnico");
		   //bloco1.get(k).setNumeroDODF(numero_DODF);
		   //bloco1.get(k).setDataDODF(data_DODF);
		   //blocoCompleto_temp.add(bloco1.get(k));
		   //System.out.println("entrei aqui!!!");
		   //System.out.println(bloco1.get(k).texto);
		   existeBlocoUnico = true;         
		  }
		 }  
		 
		 if (existeBlocoUnico) {
			//System.out.println("estou aqui!!!");
			  for (int k = 0; k <= testeBlocoUnico.size() - 1; ++k) {
				  //System.out.println(testeBlocoUnico.get(k).texto + " " + testeBlocoUnico.get(k).endY);
			  } 
		 }
		 
		 
		 
		 if (existeBlocoUnico == false) {

		  for (int k = 0; k <= testeBlocoUnico.size() - 1; ++k) {
			  //System.out.println(testeBlocoUnico.get(k).texto + " " + testeBlocoUnico.get(k).endY);
		  }    
		  
		  for (int k = 0; k <= testeBlocoUnico.size() - 1; ++k) {
		   if (testeBlocoUnico.get(k).startX >= 40 && testeBlocoUnico.get(k).startX < 415
		           && testeBlocoUnico.get(k).endX <= 415
		           && testeBlocoUnico.get(k).endY >= 80
		     && testeBlocoUnico.get(k).endY <= 880  ) {
		    //bloco1Y.add(Math.round(testeBlocoUnico.get(k).endX * (float) 1000)/ (float) 1000); 
		    bloco1Y.add(Math.round(testeBlocoUnico.get(k).endY * (float) 1000)/ (float) 1000);
		    //bloco1Y.add(testeBlocoUnico.get(k).endY); 
		   }       
		   else if (testeBlocoUnico.get(k).startX >= 415 && testeBlocoUnico.get(k).endX > 415
		           && testeBlocoUnico.get(k).endY >= 80
		     && testeBlocoUnico.get(k).endY <= 880  ) {
		    //bloco2Y.add(Math.round(testeBlocoUnico.get(k).endX * (float) 1000)/ (float) 1000);
		    bloco2Y.add(Math.round(testeBlocoUnico.get(k).endY * (float) 1000)/ (float) 1000);
		    //bloco2Y.add(testeBlocoUnico.get(k).endY); 
		    
		    
		   } 
		  }
		  
		  if ((bloco1Y.size() > 0 && bloco2Y.size() > 0)  == false) {
		  
		   //System.out.println(bloco1Y);
		   //System.out.println(bloco2Y);
		   
		   //System.out.println(bloco1Y.size());
		   //System.out.println(bloco2Y.size());   
		   

		   Set<Float> intersecBloco1Y = new HashSet<Float>(bloco1Y); 
		   Set<Float> intersecBloco2Y = new HashSet<Float>(bloco2Y); 
		   
		   blocoCompletoY.addAll(intersecBloco1Y);
		   blocoCompletoY.addAll(intersecBloco2Y);
		   
		   //System.out.println(intersecBloco1Y.size());
		   //System.out.println(intersecBloco2Y.size());
		      
		   
		   Set<Float> intersecBloco1e2Y = new HashSet<Float>(blocoCompletoY); 
		   
		   //System.out.println(intersecBloco1e2Y.size());     
		   

		   if (intersecBloco1e2Y.size() - intersecBloco1Y.size() - intersecBloco2Y.size() > 1) {
		    existeBlocoUnico = true;
		    //System.out.println(intersecBloco1Y.size());
		    //System.out.println(intersecBloco2Y.size());
		    //System.out.println(intersecBloco1e2Y.size());   
		   //} else if (bloco1Y.size() + bloco2Y.size() - intersecBloco1e2Y.size() > 5) {
		   // existeBlocoUnico = true;
		   }    
		   
		   
		  } else if (bloco1Y.size() > 0 || bloco2Y.size() > 0) {
		   
		   bloco1Y = new ArrayList<>();
		   bloco2Y = new ArrayList<>();
		   
		   for (int k = 0; k <= testeBlocoUnico.size() - 1; ++k) {
		    if (testeBlocoUnico.get(k).startX >= 415 && testeBlocoUnico.get(k).endX > 415
		            && testeBlocoUnico.get(k).endY >= 80
		      && testeBlocoUnico.get(k).endY <= 880  ) {
		     //bloco2Y.add(Math.round(testeBlocoUnico.get(k).endX * (float) 1000)/ (float) 1000);
		     bloco2Y.add(Math.round(testeBlocoUnico.get(k).endY * (float) 1000)/ (float) 1000);
		     //bloco2Y.add(testeBlocoUnico.get(k).endY);       
		     
		    } 
		   }
		   
		   //float minYBloco2 = Collections.min(bloco2Y) - 5;
		   //float maxYBloco2 = Collections.max(bloco2Y) + 5;
		   
		   float minYBloco2 = Collections.min(bloco2Y);
		   float maxYBloco2 = Collections.max(bloco2Y);		   
		   
		   //System.out.println(minYBloco2);
		   //System.out.println(maxYBloco2);
		         
		   for (int k = 0; k <= testeBlocoUnico.size() - 1; ++k) {
		    if (testeBlocoUnico.get(k).startX >= 40 && testeBlocoUnico.get(k).startX < 415
		            && testeBlocoUnico.get(k).endX <= 415
		            && testeBlocoUnico.get(k).endY >= minYBloco2
		      && testeBlocoUnico.get(k).endY <= maxYBloco2  ) {
		     //bloco1Y.add(Math.round(testeBlocoUnico.get(k).endX * (float) 1000)/ (float) 1000); 
		     bloco1Y.add(Math.round(testeBlocoUnico.get(k).endY * (float) 1000)/ (float) 1000);
		     //bloco1Y.add(testeBlocoUnico.get(k).endY); 
		    }       

		   }   
		   
		   //System.out.println(bloco1Y);
		   //System.out.println(bloco2Y);
		   
		   //System.out.println(bloco1Y.size());
		   //System.out.println(bloco2Y.size());   
		   

		   Set<Float> intersecBloco1Y = new HashSet<Float>(bloco1Y); 
		   Set<Float> intersecBloco2Y = new HashSet<Float>(bloco2Y); 
		   
		   blocoCompletoY.addAll(intersecBloco1Y);
		   blocoCompletoY.addAll(intersecBloco2Y);
		   
		   //System.out.println(intersecBloco1Y.size());
		   //System.out.println(intersecBloco2Y.size());
		      
		   
		   Set<Float> intersecBloco1e2Y = new HashSet<Float>(blocoCompletoY); 
		   
		   //System.out.println(intersecBloco1e2Y.size());     
		   
		   if (bloco1Y.size() > 0 && bloco2Y.size() > 0) {
		    //if (intersecBloco1e2Y.size() < intersecBloco1Y.size() + intersecBloco2Y.size() + 3) {
		    //if (intersecBloco1e2Y.size() < intersecBloco1Y.size() + intersecBloco2Y.size() - 3) {	
		    if (intersecBloco1e2Y.size() < intersecBloco1Y.size() + intersecBloco2Y.size()) {				    	
		     existeBlocoUnico = true;
		     //System.out.println(intersecBloco1Y.size());
		     //System.out.println(intersecBloco2Y.size());
		     //System.out.println(intersecBloco1e2Y.size());   
		    //} else if (bloco1Y.size() + bloco2Y.size() - intersecBloco1e2Y.size() > 5) {
		    // existeBlocoUnico = true;
		    }   
		   }    
		   
		  } else {
			  System.out.println("else");   
		  }
		  

		   

		       
		   

		  
		  

		   
		 }
		 //System.out.println(existeBlocoUnico); 
		 return existeBlocoUnico;

		 
		 
		 
		}
	
	
	private static boolean verificaBlocoUnico2(List<Linha> testeBlocoUnico) {

		//List<Linha> bloco1_temp = new ArrayList<>();
		//List<Linha> bloco2_temp = new ArrayList<>();
		
		boolean existeBlocoUnico = false;
		
		List<Float> bloco1Y = new ArrayList<>();
		List<Float> bloco2Y = new ArrayList<>();
		List<Float> blocoCompletoY = new ArrayList<>();
		
		for (int k = 0; k <= testeBlocoUnico.size() - 1; ++k) {
			if (testeBlocoUnico.get(k).endY >= 80 
					&& testeBlocoUnico.get(k).endY <= 880 
					&& (testeBlocoUnico.get(k).endX - testeBlocoUnico.get(k).startX > 355
					|| testeBlocoUnico.get(k).startX <= 405 && testeBlocoUnico.get(k).endX >= 415)) {
				//bloco1.get(k).setBloco("BlocoUnico");
				//bloco1.get(k).setNumeroDODF(numero_DODF);
				//bloco1.get(k).setDataDODF(data_DODF);
				//blocoCompleto_temp.add(bloco1.get(k));
				//System.out.println("entrei aqui!!!");
				//System.out.println(bloco1.get(k).texto);
				existeBlocoUnico = true;									
			}
		}		
		
		
		
		if (existeBlocoUnico == false) {

			for (int k = 0; k <= testeBlocoUnico.size() - 1; ++k) {
				//System.out.println(testeBlocoUnico.get(k).texto + " " + testeBlocoUnico.get(k).endY);
			}				
			
			for (int k = 0; k <= testeBlocoUnico.size() - 1; ++k) {
				if (testeBlocoUnico.get(k).startX >= 40 && testeBlocoUnico.get(k).startX < 415
		        		&& testeBlocoUnico.get(k).endX <= 415
		        		&& testeBlocoUnico.get(k).endY >= 80
						&& testeBlocoUnico.get(k).endY <= 880  ) {
					//bloco1Y.add(Math.round(testeBlocoUnico.get(k).endX * (float) 1000)/ (float) 1000);	
					bloco1Y.add(Math.round(testeBlocoUnico.get(k).endY * (float) 10000)/ (float) 10000);
					//bloco1Y.add(testeBlocoUnico.get(k).endY);	
				}							
				else if (testeBlocoUnico.get(k).startX >= 415 && testeBlocoUnico.get(k).endX > 415
		        		&& testeBlocoUnico.get(k).endY >= 80
						&& testeBlocoUnico.get(k).endY <= 880  ) {
					//bloco2Y.add(Math.round(testeBlocoUnico.get(k).endX * (float) 1000)/ (float) 1000);
					bloco2Y.add(Math.round(testeBlocoUnico.get(k).endY * (float) 10000)/ (float) 10000);
					//bloco2Y.add(testeBlocoUnico.get(k).endY);	
					
					
				}	
			}	
					
			//System.out.println(bloco1Y);
			//System.out.println(bloco2Y);				
			
			Set<Float> intersecBloco1Y = new HashSet<Float>(bloco1Y); 
			Set<Float> intersecBloco2Y = new HashSet<Float>(bloco2Y); 
			
			blocoCompletoY.addAll(intersecBloco1Y);
			blocoCompletoY.addAll(intersecBloco2Y);
			
			//System.out.println(intersecBloco1Y.size());
			//System.out.println(intersecBloco2Y.size());
						
			
			Set<Float> intersecBloco1e2Y = new HashSet<Float>(blocoCompletoY); 
			
			//System.out.println(intersecBloco1e2Y.size());	
			
			if (bloco1Y.size() > 0 && bloco2Y.size() > 0) {
				if (intersecBloco1e2Y.size() - intersecBloco1Y.size() - intersecBloco2Y.size() > 1) {
					existeBlocoUnico = true;
					//System.out.println(intersecBloco1Y.size());
					//System.out.println(intersecBloco2Y.size());
					//System.out.println(intersecBloco1e2Y.size());			
				} else if (bloco1Y.size() + bloco2Y.size() - intersecBloco1e2Y.size() > 5) {
					existeBlocoUnico = true;
				}			
			}
			
		
				
		}
		//System.out.println(existeBlocoUnico);	
		return existeBlocoUnico;

		
		
		
	}
	
	
	public List<List<TextPosition>> getCharactersByArticle() {
		// data.add(charactersByArticle);
		return charactersByArticle;
	}
	
	public static String confirmaDataDODF(List<String> listaDataDODF) {

		List<Integer> listaFreq = new ArrayList<>();
		
		Map<Integer, String> dicionarioFrequencia = new HashMap<Integer, String>();			
        Set<String> st = new HashSet<String>(listaDataDODF); 
        for (String s : st)	 {
        	int frequencia = Collections.frequency(listaDataDODF, s);	           	
        	listaFreq.add(frequencia);
        	dicionarioFrequencia.put(frequencia, s);	                	
        }    
        
        //System.out.println(Collections.max(listaFreq));
        
        return dicionarioFrequencia.get(Collections.max(listaFreq));
		
	}
	
	public static Integer confirmaNumeroDODF(List<Integer> listaNumeroDODF) {

		List<Integer> listaFreq = new ArrayList<>();
		
		Map<Integer, Integer> dicionarioFrequencia = new HashMap<Integer, Integer>();			
        Set<Integer> st = new HashSet<Integer>(listaNumeroDODF); 
        for (Integer s : st)	 {
        	int frequencia = Collections.frequency(listaNumeroDODF, s);	           	
        	listaFreq.add(frequencia);
        	dicionarioFrequencia.put(frequencia, s);	  
        	//System.out.println(s + ": " + Collections.frequency(listaNumeroDODF, s)); //#controle
        }    
        
        //System.out.println(Collections.max(listaFreq));
        
        return dicionarioFrequencia.get(Collections.max(listaFreq));
		
	}	
	
	public static String confirmaComplementoDODF(List<String> listaComplementoDODF) {

		List<Integer> listaFreq = new ArrayList<>();
		
		Map<Integer, String> dicionarioFrequencia = new HashMap<Integer, String>();			
        Set<String> st = new HashSet<String>(listaComplementoDODF); 
        for (String s : st)	 {
        	int frequencia = Collections.frequency(listaComplementoDODF, s);	           	
        	listaFreq.add(frequencia);
        	dicionarioFrequencia.put(frequencia, s);	                	
        }    
        
        //System.out.println(Collections.max(listaFreq));
        //System.out.println(" ---------- r isu oi rrs ");
        
        return dicionarioFrequencia.get(Collections.max(listaFreq));
		
	}	
	
	public static double mean(double[] p) {
	    double sum = 0;  // sum of all the elements
	    for (int i=0; i<p.length; i++) {
	        sum += p[i];
	    }
	    return sum / p.length;
	}//end method mean	
	
	private static boolean procuraSecao(boolean secao, Linha registroElemento, int page) {
		boolean encontrouSecao = secao;
		
		
		if (secao == false && registroElemento.endFontFamily.contains("Bold") && registroElemento.fontSizePT == 12) {

			//Pattern p = Pattern.compile("SE[Ç]C[ÃA]O II[I1l]|SE[Ç]C[ÃA]O I[I1l]");
			Pattern p1 = Pattern.compile("SE[ÇC][ÃA]O I[I1l]|SEÇÃO II");
			Matcher m1 = p1.matcher(registroElemento.texto);

			if (m1.find()) {
				System.out.println(registroElemento.texto + " localizada na página " + page); //#controle
				encontrouSecao = true;
			}
		}														
		
		if (registroElemento.endFontFamily.contains("Bold") && registroElemento.fontSizePT == 12) {

			//Pattern p = Pattern.compile("SE[Ç]C[ÃA]O II[I1l]|SE[Ç]C[ÃA]O I[I1l]");
			Pattern p1 = Pattern.compile("SE[ÇC][ÃA]O II[I1l]");
			Matcher m1 = p1.matcher(registroElemento.texto);
			
			if (m1.find()) {
				System.out.println(registroElemento.texto + " localizada na página " + page); //#controle
				encontrouSecao = true;

			}
		}
		
		/*
		if (registroElemento.endFontFamily.contains("Bold") && registroElemento.fontSizePT == 12) {

			//Pattern p = Pattern.compile("SE[Ç]C[ÃA]O II[I1l]|SE[Ç]C[ÃA]O I[I1l]");
			//System.out.println(builder.toString());
			//System.out.println(registroElemento.texto);
			Pattern p1 = Pattern.compile("INEDITORIAIS|I N E D I TO R I A I S");
			Matcher m1 = p1.matcher(builder.toString());
			
			if (m1.find()) {
				System.out.println(builder.toString() + " localizada na página " + page); //#controle
				encontrouSecao = false;

			}
		}			
		*/
		return encontrouSecao;
	}	
	
	private static int procuraNumeroDODF(List<Linha> listaElementos, Linha registroElemento, int page, int numeroDODF) throws FileNotFoundException, IOException {
		
		int numero = 0;
		
		if (page == 1 && registroElemento.endY < 300 && numeroDODF == 0) {		
			
			int k = 0;
			String elementosPassados = "";								
			
			if (listaElementos.isEmpty() || numeroDODF == 0) {
				numero = retornaNumeroDODF(registroElemento.texto);	
			}																
			else {
				while (k < listaElementos.size() -1) {
					elementosPassados = elementosPassados + listaElementos.get(k).texto;
					k = k + 1;
				}
			}
			numero = retornaNumeroDODF(elementosPassados);	
			return numero;
			
											
			
		} else if (page > 1 && registroElemento.endY < 80 && numeroDODF == 0) {
			//System.out.println(builder.toString().replace("  ", " "));
			numero = retornaNumeroDODF(registroElemento.texto);
			return numero;

		}
		return numero;
		
		
	}	

	
	private static String procuraComplementoDODF(List<Linha> listaElementos, Linha registroElemento, int page, String complementoDODF) throws FileNotFoundException, IOException {
		
		String complemento = "";
		
		if (page == 1 && registroElemento.endY < 300 && complementoDODF == "") {		
			
			int k = 0;
			String elementosPassados = "";								
			
			if (listaElementos.isEmpty()) {
				complemento = retornaComplemento(registroElemento.texto, page);	
				return complemento;
			}																
			else {
				while (k < listaElementos.size() -1) {
					elementosPassados = elementosPassados + listaElementos.get(k).texto;
					k = k + 1;
				}
			}
			complemento = retornaComplemento(elementosPassados, page);		
			return complemento;
			
		} else if (page > 1 && registroElemento.endY < 80 && complementoDODF == "") {
			//System.out.println(builder.toString().replace("  ", " "));																		
			complemento = retornaComplemento(registroElemento.texto, page);

		}
		return complemento;
		
		
	}	
	
	private static String encontraDataDODF(Linha registroElemento, int page, String dataDODF) throws FileNotFoundException, IOException {
		String data = "";
		if (page == 1 && registroElemento.endY < 300 && dataDODF == "") {																
			data = retornaData(registroElemento.texto);			
		} else if (page > 1 && registroElemento.endY < 80 && dataDODF == "") {
			data = retornaData(registroElemento.texto);													
		}		
		return data;
	}	
	
	public static int existeBlocoFlutuante2 (int j, Linha registroElemento, List<Linha> listaLinhas, boolean verificaTipoBloco) {
		
		int elementoAntecedente = 0;	
		int contadorElementosBloco = 0;
		int contadorElementosForaBloco = 0;
		float distancia = 0;
		boolean encontrouElementoFlutuante = false;
		//Map<Float, Integer> dicionario = new HashMap<Float, Integer>();
		//System.out.println(listaLinhas.size());
		//bloco1.add(registroElemento);
		if (listaLinhas.size() > 0) {
			//if (registroElemento.endFontFamily.contains("Bold") && (registroElemento.fontSizePT == 12 || registroElemento.fontSizePT == 9)) {	
			if (registroElemento.endFontFamily.contains("Bold") && (registroElemento.fontSizePT == 12)) {			
			//if (registroElemento.endFontFamily.contains("Bold") || registroElemento.fontSizePT > 8) {
				//System.out.println(registroElemento.texto);
				//System.out.println(registroElemento.TipoBloco);
				float y_atual = registroElemento.endY;
				List<Float> listaY = new ArrayList<>();
				List<Float> listaDistanciaY = new ArrayList<>();			
										
		
				for (int k = 0; k <= listaLinhas.size() - 1; ++k) {
					if (registroElemento.TipoBloco == listaLinhas.get(k).TipoBloco) {
						//dicionario.put(y_atual - listaLinhas.get(k).endY,k);
						listaY.add(listaLinhas.get(k).endY);
						//contadorElementosBloco = contadorElementosBloco + 1;
					} else {
						if (k > j) {
							break;
						} else {
							contadorElementosForaBloco = contadorElementosForaBloco + 1;
						}
						
					}
					//System.out.println(bloco1.get(j).texto);
				}
				elementoAntecedente = contadorElementosForaBloco;
			
				//System.out.println(contadorElementosForaBloco);
				
				Collections.sort(listaY);
				
				for (int k = 0; k <= listaY.size() - 1; ++k) {
					listaDistanciaY.add(listaY.get(k) - y_atual);
				}				
				
				//int size = listaDistanciaY.size();
				
				//listaDistanciaY = new ArrayList<>(new HashSet<>(listaDistanciaY));
				
				//if (listaDistanciaY.size() < size) {
				//	System.out.println("------------------------------  entrei aqui!!!!!!!!!! ------------------------------ ");
				//	contadorElementosBloco = size - listaDistanciaY.size();
				//}

				if (registroElemento.texto.equals("SECRETARIA DE ESTADO DE AGRICULTURA,")) {						
					//System.out.println(elementoAntecedente);
					//System.out.println(listaDistanciaY.size());
					
				}				
				
				Collections.sort(listaDistanciaY);
				
				for (int k = 0; k <= listaDistanciaY.size() - 1; ++k) {
					//if (registroElemento.texto.equals("PODER LEGISLATIVO")) {
					if (registroElemento.texto.equals("SECRETARIA DE ESTADO DE INFRAESTRUTURA")) {						
						//System.out.println(listaDistanciaY.get(k));
						
					}

				} 
				
				for (int k = 0; k <= listaDistanciaY.size() - 1; ++k) {					
					if (listaDistanciaY.get(k) > 0) {		
						//System.out.println(listaDistanciaY.get(k));
						//distancia = listaDistanciaY.get(k);
						//elementoAntecedente = dicionario.get(distancia);
						//System.out.println(listaDistanciaY.get(k));
						//System.out.println(elementoAntecedente);
						//System.out.println(k);
						//System.out.println(registroElemento.texto);
						//elementoAntecedente =  elementoAntecedente + 1;						
						//System.out.println(k);
						encontrouElementoFlutuante = true;
						elementoAntecedente = elementoAntecedente + contadorElementosBloco - 1;
						break;
					}	
					contadorElementosBloco = contadorElementosBloco + 1;
				}							
				
				//if (registroElemento.texto.equals("PODER LEGISLATIVO")) {

				
				
				if (encontrouElementoFlutuante == false) {
					//System.out.println(elementoAntecedente);
					elementoAntecedente = j;
					//System.out.println(elementoAntecedente);
				} else {
					//System.out.println(elementoAntecedente);
					///elementoAntecedente = j;
					//System.out.println(elementoAntecedente);					
					//elementoAntecedente = elementoAntecedente + contadorElementosForaBloco; 
					//System.out.println("SEc Flutuante");
					//System.out.println(elementoAntecedente);
					//System.out.println(registroElemento.texto);
					//System.out.println("	> Linha Flutuante: " + registroElemento.texto);	//#controle			
					
					//elementoAntecedente =  elementoAntecedente + 1;	
				}				
				
				//elementoAntecedente =  elementoAntecedente + 1;				
			
				//dictionary.get(listaMinY.get(j)
			} else {
				elementoAntecedente = j;
			}
			

		} 
		
		
		if (registroElemento.texto.equals("SECRETARIA DE ESTADO DE AGRICULTURA,")) {					
			//System.out.println(elementoAntecedente);
			//System.out.println(listaLinhas.size());
			//System.out.println(contadorElementosBloco);
			//System.out.println(encontrouElementoFlutuante);
			//System.out.println(elementoAntecedente + listaLinhas.size());
			//System.out.println(k);
			//System.out.println(verificaTipoBloco);
		}		
		
		return elementoAntecedente;
	}
		
	
	public static int existeBlocoFlutuante (Linha registroElemento, List<Linha> listaLinhas, boolean verificaTipoBloco) {
		
		int elementoAntecedente = 0;	
		int contadorElementosBloco = 0;
		int contadorElementosForaBloco = 0;
		float distancia = 0;
		boolean encontrouElementoFlutuante = false;
		//Map<Float, Integer> dicionario = new HashMap<Float, Integer>();
		//System.out.println(listaLinhas.size());
		//bloco1.add(registroElemento);
		if (listaLinhas.size() > 0) {
			if (registroElemento.endFontFamily.contains("Bold") || registroElemento.fontSizePT > 8) {
				//System.out.println(registroElemento.texto);
				float y_atual = registroElemento.endY;
				List<Float> listaDistanciaY = new ArrayList<>();			
										
				if (verificaTipoBloco) {			
					for (int k = 0; k <= listaLinhas.size() - 1; ++k) {
						if (registroElemento.TipoBloco == listaLinhas.get(k).TipoBloco) {
							//dicionario.put(y_atual - listaLinhas.get(k).endY,k);
							listaDistanciaY.add(listaLinhas.get(k).endY - y_atual);
							//contadorElementosBloco = contadorElementosBloco + 1;
						} else {
							contadorElementosForaBloco = contadorElementosForaBloco + 1;
						}
						//System.out.println(bloco1.get(j).texto);
					}
					elementoAntecedente = contadorElementosForaBloco;
				} else {
					for (int k = 0; k <= listaLinhas.size() - 1; ++k) {
						//dicionario.put(listaLinhas.get(k).endY - y_atual,k);
						listaDistanciaY.add(listaLinhas.get(k).endY - y_atual);
						//contadorElementosBloco = contadorElementosBloco + 1;
					}	
					for (int k = 0; k <= listaLinhas.size() - 1; ++k) {
						//dicionario.put(y_atual - listaLinhas.get(k).endY,k);
						//listaDistanciaY.add(y_atual - listaLinhas.get(k).endY);
					}							
				}
						

				if (registroElemento.texto.equals("SECRETARIA DE ESTADO DE INFRAESTRUTURA")) {						
					//System.out.println(elementoAntecedente);
					//System.out.println(listaDistanciaY.size());
					
				}				
				
				Collections.sort(listaDistanciaY);
				
				for (int k = 0; k <= listaDistanciaY.size() - 1; ++k) {
					//if (registroElemento.texto.equals("PODER LEGISLATIVO")) {
					if (registroElemento.texto.equals("SECRETARIA DE ESTADO DE INFRAESTRUTURA")) {						
						//System.out.println(listaDistanciaY.get(k));
						
					}

				} 
				
				for (int k = 0; k <= listaDistanciaY.size() - 1; ++k) {					
					if (listaDistanciaY.get(k) >= 0) {		
						//System.out.println(listaDistanciaY.get(k));
						//distancia = listaDistanciaY.get(k);
						//elementoAntecedente = dicionario.get(distancia);
						//System.out.println(listaDistanciaY.get(k));
						//System.out.println(elementoAntecedente);
						//System.out.println(k);
						//System.out.println(registroElemento.texto);
						//elementoAntecedente =  elementoAntecedente + 1;						
						elementoAntecedente = elementoAntecedente + k;
						encontrouElementoFlutuante = true;
						break;
					}	
					contadorElementosBloco = contadorElementosBloco + 1;
				}							
				
				//if (registroElemento.texto.equals("PODER LEGISLATIVO")) {
				if (registroElemento.texto.equals("SECRETARIA DE ESTADO DE PLANEJAMENTO,")) {					
					//System.out.println(elementoAntecedente);
					//System.out.println(listaLinhas.size());
					//System.out.println(elementoAntecedente + listaLinhas.size());
					//System.out.println(k);
					//System.out.println(verificaTipoBloco);
				}
				
				
				if (encontrouElementoFlutuante == false) {
					elementoAntecedente = listaLinhas.size();
					//System.out.println(elementoAntecedente);
				} else {
					//System.out.println("SEc Flutuante");
					//System.out.println(registroElemento.texto);
					//System.out.println("	> Linha Flutuante: " + elementoAntecedente);	//#controle		
					//System.out.println("	> Linha Size: " + listaLinhas.size());	//#controle
					
					//elementoAntecedente =  elementoAntecedente + 1;	
				}				
				
				//elementoAntecedente =  elementoAntecedente + 1;				
			
				//dictionary.get(listaMinY.get(j)
			} else {
				elementoAntecedente = listaLinhas.size();
			}
			

		} 
		
		if (distancia >= 0) {
			//System.out.println('1');
		} else if (listaLinhas.size() == 0 && contadorElementosBloco == 0){
			//System.out.println('2');
			//elementoAntecedente = 0;
		} else if (elementoAntecedente > 0 && contadorElementosBloco > 0) {
			//System.out.println('3');
		} else {
			
			//System.out.println('4');
		}
		//System.out.println(elementoAntecedente);
		return elementoAntecedente;
	}
	
	
	public static void exportDataToExcel(List<Linha> textocompleto, File file) throws FileNotFoundException, IOException {

		// String[] columns = { "Texto", "Xo", "Xf", "Y", "FontType", "FontSizePT",
		// "Height", "Xscale", "Space",
		// "PageNumber", "DODF", "Bloco", "Data" };

		String[] columns = { "DODF", "Data", "PageNumber", "Texto", "Xo", "Xf", "Y", "FontType", "FontSizePT",
				"Bloco", "Linha", "Complemento", "LinhaGeral" };

		// private static List<Employee> textocompleto = new ArrayList<>();
		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		/*
		 * CreationHelper helps us create instances of various things like DataFormat,
		 * Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way
		 */
		CreationHelper createHelper = workbook.getCreationHelper();

		// Create a Sheet
		Sheet sheet = workbook.createSheet("DODF");

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setColor(IndexedColors.BLUE.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		headerCellStyle.setAlignment(HorizontalAlignment.LEFT);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Create cell style
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		// Create a CellStyle with the font
		CellStyle defaultStyle = workbook.createCellStyle();
		// headerCellStyle.setFont(headerFont);
		defaultStyle.setAlignment(HorizontalAlignment.LEFT);

		// CellStyle decimalNumberCellStyle = workbook.createCellStyle();
		// decimalNumberCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		// Create Other rows and cells with employees data
		int rowNum = 1;
		for (Linha linha : textocompleto) {
			Row row = sheet.createRow(rowNum++);

			Cell column1 = row.createCell(0);
			column1.setCellValue(linha.numeroDODF);
			column1.setCellStyle(defaultStyle);

			Cell column2 = row.createCell(1);
			column2.setCellValue(linha.dataDODF);
			column2.setCellStyle(dateCellStyle);

			Cell column3 = row.createCell(2);
			column3.setCellValue(linha.pageNumber);
			column3.setCellStyle(defaultStyle);

			Cell column4 = row.createCell(3);
			column4.setCellValue(linha.texto);
			column4.setCellStyle(defaultStyle);

			Cell column5 = row.createCell(4);
			column5.setCellValue(linha.startX);
			column5.setCellStyle(defaultStyle);

			Cell column6 = row.createCell(5);
			column6.setCellValue(linha.endX);
			column6.setCellStyle(defaultStyle);

			Cell column7 = row.createCell(6);
			column7.setCellValue(linha.endY);
			column7.setCellStyle(defaultStyle);

			Cell column8 = row.createCell(7);
			column8.setCellValue(linha.endFontFamily);
			column8.setCellStyle(defaultStyle);

			Cell column9 = row.createCell(8);
			column9.setCellValue(linha.fontSizePT);
			column9.setCellStyle(defaultStyle);

			Cell column10 = row.createCell(9);
			column10.setCellValue(linha.TipoBloco);
			column10.setCellStyle(defaultStyle);
			
			Cell column11 = row.createCell(10);
			column11.setCellValue(linha.numeroLinha);
			column11.setCellStyle(defaultStyle);		
			
			Cell column12 = row.createCell(11);
			column12.setCellValue(linha.complemento);
			column12.setCellStyle(defaultStyle);		
			
			Cell column13 = row.createCell(12);
			column13.setCellValue(linha.numeroLinhaGeral);
			column13.setCellStyle(defaultStyle);				

		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		// Write the output to a file
		String nomeDiretorio = file.getParent();
		String nomeArquivoExcel = nomeDiretorio + "\\" + file.getName().replace(".pdf", ".xlsx");
		FileOutputStream fileOut = new FileOutputStream(nomeArquivoExcel);
		workbook.write(fileOut);
		fileOut.close();

		// Closing the workbook
		workbook.close();
	}

	
	public static void exportDataToBD(List<Linha> listaFinal) {
		/*
    	insereDODFBD db;
		try {
			db = new insereDODFBD(listaFinal);
	    	db.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}	
	
	public static Integer trataData(String data) throws FileNotFoundException, IOException {

		int mes = 0;

		String[] meses = { "JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO",
				"OUTUBRO", "NOVEMBRO", "DEZEMBRO" };

		// Pattern pMes =
		// Pattern.compile("JANEIRO|FEVEREIRO|MAR[ÇC]O|ABRIL|MAIO|JUNHO|JULHO|AGOSTO|SETEMBRO|OUTUBRO|NOVEMBRO|DEZEMBRO");
		// Matcher mMes = pMes.matcher(data);
		// if (mDataDiarioDetalhado.find()) {
		// match = mDataDiarioDetalhado.group();
		// System.out.println("------------- DIARIO: " + mDataDiarioDetalhado.group());
		// }
		for (int i = 0; i < meses.length; i++) {
			if (data.toLowerCase().contains(meses[i].toLowerCase())) {
				mes = (i + 1);
				// System.out.println(i+1);
				// System.out.println(" AHCOU O MÊS DO DODF: " + (i+1));
			}
		}

		return mes;

	}

	public static String retornaData(String data) throws FileNotFoundException, IOException {

		String dataDODF = "";
		//System.out.println(" ------- entrou aqui -----");
		//System.out.println(data); //#controle
		
		Pattern pDataDiario = Pattern.compile(
				"ANO .* N[°ºo][-]?\\r?\\n?.* \\d\\d\\d\\d|ANO .* N[°ºo][-]?\\r?\\n?.*|N[ºo].* \\d{4}$|BRASÍLIA.* \\d\\d\\d\\d");
		Pattern pDataDiarioDetalhado = Pattern.compile("\\d{1,2}[ ]?[Dd][Ee].*\\d{4}");
		Pattern pDia = Pattern.compile("\\d{1,2}");
		Pattern pAno = Pattern.compile("\\d{4}");

		Matcher mDataDiario = pDataDiario.matcher(data);
		if (mDataDiario.find()) {
			String match = mDataDiario.group();
			String mes = "";
			String dia = "";
			String ano = "";
			//System.out.println("achou " + mDataDiario.group());
			Matcher mDataDiarioDetalhado = pDataDiarioDetalhado.matcher(match);
			if (mDataDiarioDetalhado.find()) {
				match = mDataDiarioDetalhado.group();
				Matcher mDia = pDia.matcher(match);
				if (mDia.find()) {
					//System.out.println(mDia.group());
					dia = mDia.group();
					if (dia.length() < 2) {
						dia = "0" + dia;
					}
				}
				mes = Integer.toString(trataData(mDataDiarioDetalhado.group()));
				if (mes.length() < 2) {
					mes = "0" + mes;
				}
				Matcher mAno = pAno.matcher(match);
				if (mAno.find()) {
					ano = mAno.group();
					if (ano.length() < 3) {
						ano = "20" + ano;
					}
				}	
				// data_DODF = trataData(mDataDiarioDetalhado.group())
				dataDODF = dia + "-" + mes + "-" + ano;
				//System.out.println(dataDODF);
			}
		}

		return dataDODF;
	}

	public static Integer retornaNumeroDODF(String data) throws FileNotFoundException, IOException {

		
		//System.out.println(data); //#controle
		int numeroDODF = 0;

		Pattern pNumeroDiario = Pattern.compile(
				"ANO .* N[°ºo][-]?\\r?\\n?.*\\d\\d\\d\\d|ANO .* N[°ºo][-]?\\r?\\n?.*|N[°ºo].*\\d{1,3}|N[°ºo].*\\d\\d\\d\\d");

		Pattern pNumeroDiarioDetalhado = Pattern.compile("N[°ºo][-]?.*\\d{1,3}");

		Pattern pNumero = Pattern.compile("\\d{1,3}");

		Matcher mNumeroDiario = pNumeroDiario.matcher(data);
		if (mNumeroDiario.find()) {
			String match = mNumeroDiario.group();
			// System.out.println(match);
			// achado = mNumeroDiario.group();
			match = match.replace("\\r", "");
			match = match.replace("\\n", "");
			// System.out.println(achado);
			// System.out.println(match);

			String numero = "";
			Matcher mNumeroDiarioDetalhado = pNumeroDiarioDetalhado.matcher(match);
			if (mNumeroDiarioDetalhado.find()) {
				match = mNumeroDiarioDetalhado.group();
				Matcher mNumero = pNumero.matcher(match);
				if (mNumero.find()) {
					numero = mNumero.group();
					if (numero.length() < 2) {
						numero = "0" + numero;
					}
					if (numero.length() < 3) {
						numero = "0" + numero;
					}
				}

				numeroDODF = Integer.valueOf(numero);
				// System.out.println(numeroDODF);
				// data_DODF = trataData(mDataDiarioDetalhado.group());
			}
		}

		return numeroDODF;
	}

	
	public static List<Float> getOverlap (List<Float> a, List<Float> b) {
		List<Float> res = new ArrayList<>();
		res.add(Math.max(a.get(0), b.get(0)));
		res.add(Math.min(a.get(1), b.get(1)));		
		return res;  	    	    
	    
	}
	
	public static String retornaComplemento(String data, int page) throws FileNotFoundException, IOException {

		String complemento = "";
		
		//Pattern pSuplemento = Pattern.compile("SUPLEMENTO");
		Pattern pSuplemento = Pattern.compile("SUPLEMENTO[ ]?.[-]?[ ]?..");
		Matcher mSuplemento = pSuplemento.matcher(data);

		if (mSuplemento.find()) {
			complemento = mSuplemento.group().replace("  ", " ");
			return complemento;
		}			
		
		
		//Pattern pExtra = Pattern.compile("EDI[ÇC][ÃA]O EXTRA|Edição Extra");
		Pattern pExtra = Pattern.compile("EDI[ÇC][ÃA]O EXTRA");		
		Matcher mExtra = pExtra.matcher(data);

		if (mExtra.find()) {
			//System.out.println("achou");
			//System.out.println(mExtra.group());
			complemento = "EDIÇÃO EXTRA";
			return complemento;
		}			
				
		
		//System.out.println(data);
		if (page == 1) {
			
			Pattern pIntegra = Pattern.compile("EDI[ÇC][ÃA]O N");
			Matcher mIntegra = pIntegra.matcher(data);

			if (mIntegra.find()) {
				complemento = "INTEGRA";
				return complemento;
			}				
			
		} else {
			
			Pattern pIntegra = Pattern.compile("Diário Oficial do Distrito Federal$");
			Matcher mIntegra = pIntegra.matcher(data);

			if (mIntegra.find()) {
				complemento = "INTEGRA";
				return complemento;
			}				
		}
		

		

		
		


		return complemento;
	}	
	

	
}