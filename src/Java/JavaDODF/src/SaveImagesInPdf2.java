import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
 
import javax.imageio.ImageIO;
 
/**
* This is an example on how to extract images from pdf.
*/
public class SaveImagesInPdf2 extends PDFStreamEngine
{
	
    public int numeroPagina;
    public int contadorImagens;    
    public String prefix;
    public PDPage page;
    
    /**
     * Default constructor.
     *
     * @throws IOException If there is an error loading text stripper properties.
     */
    public SaveImagesInPdf2(PDPage page, int numeroPagina, int contadorImagens, String prefix) throws IOException
    {
    	super();
    	this.page = page;
    	this.numeroPagina = numeroPagina;
    	this.contadorImagens = contadorImagens;
    	this.prefix = prefix;
    }
    
    
    
    public int imageNumber = 1;
    public int contadorImagensSalvas = 0;
 
    /**
     * @param args The command line arguments.
     *
     * @throws IOException If there is an error parsing the document.
     */
    public void run() throws IOException
    {
    	//SaveImagesInPdf2 printer = new SaveImagesInPdf2();
        processPage(getPage());

    }
    
    protected PDPage getPage()
    {
        return this.page;
    }    
 
    /**
     * @param operator The operation to perform.
     * @param operands The list of arguments.
     *
     * @throws IOException If there is an error processing the operation.
     */
    @Override
    protected void processOperator( Operator operator, List<COSBase> operands) throws IOException
    {
        String operation = operator.getName();
        if( "Do".equals(operation) )
        {
            COSName objectName = (COSName) operands.get( 0 );
            
            
            PDXObject xobject = getResources().getXObject( objectName );
            if( xobject instanceof PDImageXObject)
            {
            	
            	PDImageXObject image = (PDImageXObject)xobject;
                int imageWidth = image.getWidth();
                int imageHeight = image.getHeight();
                
                contadorImagensSalvas = contadorImagensSalvas + 1;
                
                //System.out.println("\nImage [" + objectName.getName() + "]");
                
                //Matrix ctmNew = getGraphicsState().getCurrentTransformationMatrix();
                //float imageXScale = ctmNew.getScalingFactorX();
                //float imageYScale = ctmNew.getScalingFactorY();
                
               
                
                //System.out.println( getGraphicsState().getCurrentTransformationMatrix().getShearX());
                //System.out.println( getGraphicsState().getCurrentTransformationMatrix().getShearY());
                
                // position of image in the pdf in terms of user space units
                //System.out.println("position in PDF = " + ctmNew.getTranslateX() + ", " + ctmNew.getTranslateY() + " in user space units");
                // raw size in pixels
                //System.out.println("raw image size  = " + imageWidth + ", " + imageHeight + " in pixels");
                // displayed size in user space units
                //System.out.println("displayed size  = " + imageXScale + ", " + imageYScale + " in user space units");


                // same image to local
                BufferedImage bImage = new BufferedImage(imageWidth,imageHeight,BufferedImage.TYPE_INT_ARGB);
                bImage = image.getImage();
                //System.out.println(bImage.getWidth());
                //System.out.println(bImage.getHeight());
                //String fileName = "C:\\TesteOCR\\DODF\\temp2\\" + "image_" + contadorImagensSalvas + ".png";
                
                
 
            
                String fdfFile = prefix.substring(0, prefix.length() -4);
                String fileName = fdfFile + "-pagina-" + numeroPagina + "-imagem-" + contadorImagensSalvas + ".png";                
                
                
                File file = new File(fileName);
                ImageIO.write(bImage,"PNG",file);
                long fileSize = file.length();
                //System.out.println(fileSize/1024);
                if (fileSize/1024 < 10) {                	
                	file.delete();
                	contadorImagensSalvas = contadorImagensSalvas - 1;
                } else {                    
                	//System.out.println("Image saved.");
                    //System.out.println("\nImage [" + objectName.getName() + "]");
                    
                    Matrix ctmNew = getGraphicsState().getCurrentTransformationMatrix();
                    float imageXScale = ctmNew.getScalingFactorX();
                    float imageYScale = ctmNew.getScalingFactorY();

                    float yScaling = ctmNew.getScaleY();
                    float angle = (float)Math.acos(ctmNew.getValue(0, 0)/ctmNew.getScaleX());
                    if (ctmNew.getValue(0, 1) < 0 && ctmNew.getValue(1, 0) > 0)
                    {
                        angle = (-1)*angle;
                    }

                    PDPage page = getCurrentPage();
                    double pageHeight = page.getMediaBox().getHeight();
                    ctmNew.setValue(2, 1, (float)(pageHeight - ctmNew.getTranslateY() - Math.cos(angle)*yScaling));
                    ctmNew.setValue(2, 0, (float)(ctmNew.getTranslateX() - Math.sin(angle)*yScaling));

                    // because of the moved 0,0-reference, we have to shear in the opposite direction
                    ctmNew.setValue(0, 1, (-1)*ctmNew.getValue(0, 1));
                    ctmNew.setValue(1, 0, (-1)*ctmNew.getValue(1, 0));

                    //System.out.println("NEW NEW:  position in PDF = " + ctmNew.getTranslateX() + ", " + ctmNew.getTranslateY() + " in user space units");
                } 
                
                imageNumber++;
                
            }
            else if(xobject instanceof PDFormXObject)
            {
                PDFormXObject form = (PDFormXObject)xobject;
                showForm(form);
            }
        }
        else
        {
            super.processOperator( operator, operands);
        }
    }
 
}