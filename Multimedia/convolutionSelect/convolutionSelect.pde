//******************attributs***********************************************/////
PImage img; int cpt;PImage img2,img3;
boolean imageSelected=false;
 
/*float[][] noyau = {{ -1, -1, -1 },
                     { -1,  0, -1 },
                     { -1, -1, -1 }}; */
            //Sharpen:
/*float[][] noyau = {  
                       { -1, -1, -1,-1,1} , 
                       { -1, -1, -1,-1,-1},
                       {-1, -1, 30, -1,-1} ,
                       { -1, -1, -1,-1,-1} ,
                       { -1, -1, -1,-1,-1}};*/
                   
   /*float[][] noyau  = { { -1, -1, -1 } , 
                     { -1, 9, -1 } ,
                     { -1, -1, -1 } } ;// {  
                        */
                  float[][] noyau  = { { 0, -1, 0 } , 
                     { -1, 9, -1 } ,
                     { 0, -1, 0 } } ;   
//float[][] noyau = {  { 0, 1, 0 } , { 1, -15, 1 } ,{ 0, 1, 0 } } ; //le noyeau 
int size =3; //la taille de noyeau
String path="img.jpg";
//**********************************setup et draw*************************************
void setup() { 
size(1024,778); background(0);
 selectInput("Select a file to process:", "fileSelected");
//charger image 
}
int mx,my,endMx,endMy,initMx,initMy;
int h,w, var=0, varK=0;
void draw() { 
   if (imageSelected) {
image(img,0,0); //l'affichage d'image chargée 
  // chrger les pixels
  
  if(var==1 || mousePressed)
  {initMx=mx;initMy=my;
    show();drawSelection(mx,my);
   // crop();
  }
  if(var==2 && keyPressed && varK==1)
  {crop();show();
  }  }
}
//*******************************quelques fonction utils pour l'interface**********
void fileSelected(File selection) {
  if (selection == null) {
    println("Window was closed or the user hit cancel.");
  } else {
    println("User selected " + selection.getAbsolutePath());
    String theNameThatHasBeenEntered  = selection.getAbsolutePath(); 
    img = loadImage( theNameThatHasBeenEntered );
    imageSelected = true; 
  }
}
void keyPressed()
{if(key == 'c' || key == 'C')
{varK = 1;
}
}
void mousePressed() { 
  mx=mouseX;my=mouseY;
  var=1;endMx=mouseX;endMy=mouseY;
 
 }
 void mouseReleased()
 {endMx=mouseX;endMy=mouseY;var=2; 
 }
//*********************fonction pour le traitement***********************************
 void getHeight(){ 
   if(endMx>mx)h= endMx-mx;
   else h=mx-endMx;}
 void getWidth(){ if(endMy>my) w=endMy-my;
   else w=my-endMy;};
 
  //----fonction qui permet de tracer le rectangle de selection 
  
  void drawSelection(int x,int y)
  {
  pushMatrix();
  getHeight();
  getWidth();
  noFill();
  stroke(color(255,0,0));
  //rect(pmouseX,pmouseY,mouseX,mouseY,h*w);
  background(0);image(img,0,0);
  rect(x,y,mouseX,mouseY,h*w);
  popMatrix();
  }
 //recuperer les pixels se trouvant dans la zone sélectionné dans 
  //img_recup et appliquer la convolution dans la fonction sharpnen
 void crop()
 { var=0;
  
  getHeight();
  getWidth();
  PImage img_recup;
  
  img_recup = img.get(initMx,initMy,endMx,endMy);
 
 sharpnen(img_recup);
 
 pushMatrix();
 
 image(img_recup,initMx,initMy);  
 saveImage();
 
 popMatrix();
}
void sharpnen(PImage img_recup)
{
  drawConvol(img_recup,noyau); 
} 
  
/********Function appliyed on the image****/

  void show()
 {image(img,0,0);
 }
 void saveImage()
 {saveFrame("img2_"+cpt+".jpg"); cpt++;
 } 

void drawConvol(PImage img, float[][] noyau)
{
   img.loadPixels();// chrger les pixels
  for (int x = 0; x <img.width; x++) 
  {   //parcours horizontale pour la zone selectionnée 
    for (int y = 0; y < img.height; y++)
    {  //parcours verticale pour la zone selectionnée 
    int pos = x + y * img.width;  //recuperer les pixels de l'image 
    color c = convolution(x,y,noyau,size,img); //appliquer la convolution de filtrage sur la zone selectionnée avec la souris
    img.pixels[pos] = c;   //affecter le resultet de filtrage à tous les pixels 
    } 
  } 
  img.updatePixels(); 
}

color convolution(int x, int y, float[][] matrix, int matrixsize, PImage img) 
{
  float rtotal = 0.0;
  float gtotal = 0.0;
  float btotal = 0.0;
  int offset = matrixsize / 2;
  
  // Loop through convolution matrix
  for (int i = 0; i < matrixsize; i++ ) 
  {
    for (int j = 0; j < matrixsize; j++ ) 
    {
      
      // What pixel are we testing
      int xloc = x + i-offset;
      int yloc = y + j-offset;
      int loc = xloc + img.width*yloc;
      
      // Make sure we haven't walked off the edge of the pixel array
      // It is often good when looking at neighboring pixels to make sure we have not gone off the edge of the pixel array by accident.
      loc = constrain(loc,0,img.pixels.length-1);
      
      // Calculate the convolution
      // We sum all the neighboring pixels multiplied by the values in the convolution matrix.
      rtotal += (red(img.pixels[loc]) * matrix[i][j]);
      gtotal += (green(img.pixels[loc]) * matrix[i][j]);
      btotal += (blue(img.pixels[loc]) * matrix[i][j]);
    }
  }
  
  // Make sure RGB is within range
  rtotal = constrain(rtotal,0,255);
  gtotal = constrain(gtotal,0,255);
  btotal = constrain(btotal,0,255);
  
  // Return the resulting color
  return color(rtotal,gtotal,btotal); }
