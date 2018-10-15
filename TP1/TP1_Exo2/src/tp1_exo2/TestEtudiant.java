/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_exo2;

import java.util.Scanner;

/**
 * classe TestEtudiant
 * Gestion des étudiants, classe principale
 * @author CALVO Manuela
 */
public class TestEtudiant {

    
    public static void main(String args[])
    {
        //Déclaration variables 
        Etudiant e1;
        Etudiant e2 ;
        int choix;
        String ID = " ";
        String nom = " ";
        String prenom = " ";
        int taille;
        float[] tab;
        
        
        //Mise en place de la lecture clavier
        Scanner keyboard = new Scanner(System.in);
        
        
        do
        {System.out.println(" Ce programme permet la gestion de 2 élèves ");
        System.out.println(" Voulez-vous traiter les informations ...");
        System.out.println( " 1. du 1er élève");
        System.out.println( " 2. du 2ième élève");
        choix = keyboard.nextInt();
        } while (choix!=1 && choix!=2);
        
                switch(choix)
                {
                    case 1 :
                        //Instanciation du premier élève
                         e1 = new Etudiant();
                        traitement(e1);
                    break;
                    
                    case 2 :
                        nom = "test_nom ";
                        prenom = " test_prenom ";
                        ID = " test_ID ";
                        
                        System.out.println(" Saisir taille tableau");
                        taille = keyboard.nextInt();
        
                        //Création du tableau
                        tab = new float[taille];
        
                        //Remplissage tableau 
                        System.out.println(" Saisir " + taille + " flottants représentant les notes de l'élève");
                        for(int i=0; i< taille; i++)
                        {
                        tab[i] = keyboard.nextFloat();
            
                        } 
                        //Instanciation du second étudiant avec comme paramètre le tableau saisi
                        e2 = new Etudiant(nom, prenom, tab,taille, ID);
                        traitement(e2);
                        
                };
        
        //Fin de la lecture clavier
        keyboard.close();
    }

    private static void traitement(Etudiant e) {
        
        //Mise en place de la lecture clavier
        Scanner keyboard = new Scanner(System.in);
        
        //Déclaration variables
        int taille;
        float[] tab;
        String ID = " ";
        String nom = " ";
        String prenom = " ";
        float note;
        boolean present;
        
        
        //Affichage des informations de l'élève
        System.out.println("Infos étudiant");
        System.out.println( e.toString());
        System.out.println(" Tableau : ");
        e.affichage_tab();
        System.out.println();
        
        
        
        System.out.println(" Modification des informations de l'élève : ");
        System.out.println();
        
        //Demande saisi des information
        System.out.println("Saisir ID");
        ID = keyboard.next();
        
        System.out.println("Saisir Nom");
        nom = keyboard.next();
        
        System.out.println("Saisir Prenom");
        prenom = keyboard.next();
        
        System.out.println(" Saisir taille tableau");
        taille = keyboard.nextInt();
        
        //Création du tableau
        tab = new float[taille];
        
        //Remplissage tableau 
        System.out.println(" Saisir " + taille + " flottants représentant les notes de l'élève");
        for(int i=0; i< taille; i++)
        {
            tab[i] = keyboard.nextFloat();
            
        } 
        
        //Appel méthode pour modifier les informations de l'élève
        e.modifier(ID, taille, tab, nom, prenom);
        
        //Affichage des informations de l'élève
        System.out.println("Infos élève");
        System.out.println( e.toString());
        System.out.println(" Tableau : ");
        e.affichage_tab();
        System.out.println();
        
        //Affichage des stats du tableau de notes 
        e.stat();
        System.out.println();
        
        //Recherche d'une note dans le tableau 
        System.out.println(" Entrer une note a chercher dans le tableau");
        note = keyboard.nextFloat();
        
        present = e.presence(note);
        
        //Si la valeur est présente
        if(present == true)
        {
            System.out.println(" La note " + note + " est présente dans le tableau de notes ");
        }
        //Si la note n'est pas présente
        else System.out.println(" La note " + note + " n'est pas présente dans le tableau de notes ");
        System.out.println();
        
        
        //Affichage tableau avant tri
        System.out.println("Affichage tableau e1 sans tri");
        e.affichage_tab();
        
        //Affichage tableau après tri
        e.tri();
  
        System.out.println();
        
        //Remplissage d'un tableau aléatoire
        System.out.println("Affichage d'un nouveau tableau aléatoire");
        e.remplissage_tab();
        
        //Tri de ce nouveau tableau
        e.tri();
    }
}

  