package control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Henrique
 */
public class Rotator {
    private final String images[] = { "Images/Netflix.png",
      "Images/HBO.png", "Images/Disney+.png","Images/PrimeVideo.png"  };
      
   private final String links[] = {
      "https://www.netflix.com/",
      "https://www.hbo.com/",
      "https://www.disneyplus.com/",
      "https://www.primevideo.com/"};
         
   private int selectedIndex = 0;

   public String getImage()
   {
      return images[ selectedIndex ];
   } 
   public String getLink()
   {
      return links[ selectedIndex ];
   } 

   public void nextAd()
   {
      selectedIndex = ( selectedIndex + 1 ) % images.length;
   } 
}
