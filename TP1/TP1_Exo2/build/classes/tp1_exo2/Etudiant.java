/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_exo2;

import java.util.Random;

/**
 * classe Etudiant
 * Comprend les attributs et méthodes nécessaires à la gestion d'étudiants
 * @author CALVO Manuela
 */
public class Etudiant {
    
    ///Attributs
    //ID de l'étudiant
    private String m_ID;
    //Tableau de notes de l'étudiant
    private float[] m_tab_notes; 
    //Taille du tableau de notes
    private int m_taille;
    //Nom de l'étudiant
    private String m_nom;
    //Prenom de l'étudiant
    private String m_prenom;
    
    /**
     * Constructeur par défault
     * 
     */
    public Etudiant()
    {
        m_ID = " ";
        m_taille = 0;
        m_tab_notes = new float[m_taille];
        m_nom = " ";
        m_prenom = " ";    
    }
    
    /**
     * Constructeur surchargé
     * @param _nom
     *          Le nouveau nom de l'élève
     * @param _prenom
     *          Le nouveau prénom de l'élève
     * @param _tab_notes
     *          Le nouveau tableau de notes de l'élève
     * @param _taille
     *          La nouvelle taille du tableau de notes de l'élève
     * @param _ID
     *          Le nouvel ID de l'élève
     */
    public Etudiant(String _nom, String _prenom, float[] _tab_notes, int _taille, String _ID)
    {
        m_ID = _ID;
        m_taille = _taille;
        m_tab_notes = new float[m_taille]; 
        m_tab_notes = _tab_notes;
        m_nom = _nom;
        m_prenom = _prenom;    
    }
    
    /**
     * Méthode modifier qui permet de modifier les données de l'étudiant
     * @param _ID
     *      Le nouvel ID de l'étudiant
     * @param _taille
     *      La nouvelle taille du tableau de notes de l'élève
     * @param _tab_notes
     *      Le nouveau tableau de notes de l'étudiant
     * @param _nom
     *      Le nouveau nom de l'élève
     * @param _prenom
     *      Le nouveau prenom de l'étudiant
     */
    public void modifier( String _ID, int _taille, float[] _tab_notes, String _nom, String _prenom)
    {
        setID(_ID);
        setTaille( _taille);
        setTab( _tab_notes);
        setNom(_nom);
        setPrenom (_prenom);    
    }     
    
    /**
     * Méthode affichage_tab qui permet d'afficher les notes contenu dans le tableau de notes de l'étudiant 
     * 
     */
    public void affichage_tab()
    {
        //Parcours du tableau
        for(int i =0; i< getTaille() ; i++)
        {
            //Affichage de la note
            System.out.print(getTab()[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * Méthode remplissage_tab permet de remplir le tableau de notes aléatoirement
     * 
     */
    public void remplissage_tab()
    {
       
        //Déclaration et initialisation des valeurs
        //min
        float min = 0;
        //max
        float max = 20f;
        //nombre aléatoire
        Random rand = new Random();
       
        System.out.println("Tab sans tri ");
        //parcours du tableau
        for(int i = 0; i<getTaille(); i++)
       {
           //Génération d'une note comprise entre 0 et 20
           float n= (max - min)*rand.nextFloat()+ min; 
           //Stockage de la note dans le tableau
           getTab()[i]= n;
       }
        //Appel méthode afficher_tab pour afficher le tableau à l'écran
       affichage_tab();
    }
    
    /**
     * Méthode tri permet de trier les notes du tableau dans l'ordre croissant
     * 
     */
    public void tri()
    {
        //déclaration d'une valeur de stockage
        float a;
        System.out.println("Tab apres tri : ");
        
        //Parcours du tableau
        for(int j = 0; j< getTaille() - 1; j++)
        {
        for(int i = 0; i< getTaille() -1; i++)
        {
            //Si la note suivante est inférieur à la note actuelle
            if(getTab()[i]> getTab()[i+1])
            {
                //On stock la valeur de la note suivante dans notre variable de stockage
                a = getTab()[i];
                //On échange la valeur actuelle et la valeur suivante
                getTab()[i]= getTab()[i+1];
                getTab()[i+1]= a;
            }
        }
        }
        //Appel à la méthode affichage_tab qui affiche le tableau de notes à l'écran
       affichage_tab();
    }
    
     /**
     * Méthode stat qui permet de trouver la plus petite et grange note, la moyenne des notes et le poucentage de notes inf 8, entre 8 et 12 et  sup 12
     * 
     */
    public void stat()
    {
        
        //Déclaration et initialisation des variables
        float min = getTab()[0];
        float max = getTab()[0];
        float moyenne = 0;
        //Nombre de notes inf à 8
        int compteur1 = 0;
        //Pourcentage de notes inf à 8 
        float pourc1;
        //Nombre de notes entre 8 et 12
        int compteur2 = 0;
        //Pourcentage de notes entre 8 et 12 
        float pourc2;
        //Nombre de notes sup à 12
        int compteur3 = 0;
        //Pourcentage de notes sup à 12 
        float pourc3;
        
        //Identification du min et du max
        System.out.println("MIN Max : ");
         
        //Parcours du tableau
        for(int i = 1; i< getTaille(); i++)
        {
            //Si la note actuelle est inférieure au minimum
            if(getTab()[i]< min)
            {
                //cette valeur devient le minimum
                min = getTab()[i];
              
            }
            //Si la note actuelle est supérieur au maximum
            else if (getTab()[i]> max)
            {
                //cette valeur devient le maximum
                 max = getTab()[i];
            }
        }
        
        System.out.println(" le min est " + min);
       
        System.out.println(" le max est " + max);
        
        //Calcul de la moyenne
        System.out.println(" Moyenne : ");
          
        //Parcours du tableau
        for(int i= 0; i< getTaille(); i++)
        {
            //On additionne toutes les notes du tableau
        moyenne += getTab()[i];   
        }
        //On divise cette somme par le nombre de notes totales
        moyenne = (moyenne/getTaille());
        //affichage moyenne
        System.out.println(" Moyenne est " + moyenne);
        
        //Calcul du pourcentage de note inf à 8
        System.out.println(" notes < 8 " );
        
        //parcours tableau
        for(int i=0; i< getTaille(); i++)
        {
            //Si note inf à 8
            if(getTab()[i]< 8)
            {
                //on incrémente le nombre de valeur inf à 8
                compteur1 ++;
            }
        }
        //On calcul le pourcentage entre le nombre de valeur inf à 8 et le nombre total de notes
        pourc1 = ( compteur1 * 100)/getTaille();
        //affichage de ce pourcentage
        System.out.println( "le pourcentage de note < 8 est de " + pourc1);
    
        
        //Calcul du pourcentage de note entre 8 et 12
        System.out.println(" 8 < notes < 12 " );
        
        //Parcours du tableau
        for(int i=0; i< getTaille(); i++)
        {
            //Si note entre 8 et 12 
            if(getTab()[i]>= 8 && getTab()[i]<= 12)
            {
                //on incrémente le nombre de valeur entre 8 et 12
                compteur2 ++;
            }
        }
        pourc2 = ( compteur2 * 100)/ getTaille();
        //affichage de ce pourcentage
        System.out.println( "le pourcentage de note entre 8 et 12  est de " + pourc2);
    
        
        //Calcul du pourcentage de note entre 8 et 12
        System.out.println(" notes > 12 " );
        
        //Parcours du tableau
        for(int i=0; i< getTaille(); i++)
        {
            //Si note entre sup à 12
            if(getTab()[i]> 12 )
            {
                //on incrémente le nombre de valeur sup à 12
                compteur3 ++;
            }
        }
        pourc3 = ( compteur3 * 100)/ getTaille();
        //affichage de ce pourcentage
        System.out.println( "le pourcentage de note > 12  est de " + pourc3);
    
    
    
    }
    
    /**
     * Méthode presence qui permet de vérifier si une note se trouve dans le tableau
     * @param  nombre
     *      La note a trouvé dans le tableau
     * @return pres
     *      Renvoi la présence ou non de la note
     */
    public boolean presence(float nombre)
    {
        //Déclaration variable
        boolean pres = false;
        
        //Parcours tableau
        for(int i=0; i<getTaille(); i++)
        {
            //Si la note actuelle du tableau est égale à la note recherchée
            if (getTab()[i] == nombre)
            {
                //On informe que la valeur se trouve bien dans le tableau
                pres = true;
                
            }
        }
        
        return pres;
    }
    
    /**
     * Méthode toString qui permet d'afficher les informations de l'étudiant
     * @return chaine
     *      Description de l'étudiant
     */
    @Override
    public String toString()
    {
        String chaine;
        chaine = " Nom : " + getNom() + " Prenom : " + getPrenom() + " ID : " + getID() + " Taille tableau : " + getTaille();
       
        return chaine; 
    }
    
    /**
     * Méthode getID permet de retourner la valeur de l'ID de l'étudiant
     * @return m_ID
     *      ID de l'étudiant
     */
    public String getID()
    {
        return m_ID;
    }
    
    /**
     * Méthode getTaille permet de retourner la valeur de la taille du tableau de l'étudiant
     * @return m_taille
     *      taille du tableau de notes de l'étudiant
     */
     public int getTaille()
    {
        return m_taille;
    }
     
     /**
     * Méthode getTab permet de retourner le tableau de notes de l'étudiant
     * @return m_tab_notes
     *      tableau de notes de l'étudiant
     */
     public float[] getTab()
    {
        return m_tab_notes;
    }
     
     /**
     * Méthode getNom permet de retourner la valeur du nom de l'étudiant
     * @return m_nom
     *      nom de l'étudiant
     */
     public String getNom()
     {
         return m_nom;
     }
     
     /**
     * Méthode getPrenom permet de retourner la valeur du prénom de l'étudiant
     * @return m_prenom
     *      prenom de l'étudiant
     */
     public String getPrenom()
     {
         return m_prenom;
     }

     /**
     * Méthode setID permet de modifier la valeur de l'ID de l'étudiant
     * @param  _ID
     *      Le nouvel ID de l'étudiant
     */
     public void setID(String _ID)
    {
        if(_ID != " ")
        {
            m_ID = _ID;
        }
         else System.out.println("Valeur incorrecte de l'ID ");  
    
    }
     
     /**
     * Méthode setTaille permet de modifier la valeur de la taille du tableau de notes de l'étudiant
     * @param  _taille
     *      La nouvelle taille de l'étudiant
     */
     public void setTaille(int _taille)
    {
        if(_taille> 0)
        {
            m_taille = _taille;
        }
        else System.out.println("Valeur incorrecte de taille ");
        
    }
     
     /**
     * Méthode setTab permet de modifier la valeur du tableau de notes de l'étudiant
     * @param  _tab_notes
     *      Le nouveau tableau de notes de l'étudiant
     */
     public void setTab( float[] _tab_notes)
    {
        if(_tab_notes.length != 0)
        {
            m_tab_notes = _tab_notes;
        }
       else System.out.println("Valeur incorrecte du tableau de notes ");  
    }
    
     /**
     * Méthode setNom permet de modifier la valeur du nom de l'étudiant
     * @param  _nom
     *      Le nouveau nom de l'étudiant
     */
     public void setNom( String _nom)
     {
         if(_nom != " ")
         {
             m_nom = _nom;
         }
          else System.out.println("Valeur incorrecte du tableau du nom ");  
    
     }
     
     /**
     * Méthode setPrenom permet de modifier la valeur du prénom de l'étudiant
     * @param  _prenom
     *      Le nouveau prenom de l'étudiant
     */
     public void setPrenom( String _prenom)
     {
         if(_prenom != " ")
         {
             m_prenom = _prenom;
         }
          else System.out.println("Valeur incorrecte du tableau du prenom ");  
    
     }
}
