package controleur;

import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import java.awt.Color;
import java.io.File;

import ihm.FramePrincipale;
import ihm.explorer.Explorer;
import ihm.explorer.FolderListener;
import metier.Metier;


/**
 * Classe Controleur
 * Permet de gérer les interactions entre l'ihm et le metier
 * @author Floris Robart
 * @version 1.0
 */
public class Controleur
{
    private Metier          metier;
    private FramePrincipale ihm;


    public Controleur()
    {
        this.metier = new Metier         (this);
        this.ihm    = new FramePrincipale(this);
    }


    /*========*/
    /* Thèmes */
    /*========*/
    /**
     * Permet d'appliquer le thème à l'ihm
     */
    public void appliquerTheme() { this.ihm.appliquerTheme(); }

    /**
     * Permet de à l'ihm de récupérer la hashmap contenant les couleurs du thème
     * @return HashMap contenant les couleurs du thème
     */
    public HashMap<String, Color> getTheme() { return this.metier.getTheme(); }

	/**
	 * Permet de récupérer le nom partièle du thème utilisé (nom complet : theme_X.xml)
	 * @return Nom du thème utilisé (nom renvoyé par cette méthode : X)
	 */
	public String getThemeUsed() { return this.metier.getThemeUsed(); }

    /**
     * Change le thème à utilisé dans le fichier de sauvegarde.
     * Charge en mémoire le nouveau thème.
     * Met à jour l'ihm.
     * @param theme : Nom du thème à utiliser
     */
    public void changerTheme(String theme) { this.metier.setThemeUsed(theme); }

    /**
     * Permet de renommer le fichier avec le nom du thème et de changer le nom enregistrer dans le fichier de sauvegarde.
     * @param nomFichier : nouveau nom du fichier
     */
    public void setNomFichier(String nomFichier) { this.metier.setNomFichier(nomFichier); }

    /**
     * Permet de vérifier si le nom du thème est valide
     * @param nomTheme : Nom du thème à vérifier
     * @return boolean : true si le nom est valide, sinon false
     */
    public boolean verifNomTheme(String nomTheme) { return this.metier.verifNomTheme(nomTheme); }

    /**
     * Permet de mettre à jour la liste des noms des thèmes dans le métier. 
     */
    public void majLstNomTheme() { this.metier.majLstNomTheme(); }

    /**
     * Permet de fermer la fenêtre de création de thème
     */
    public void disposeFrameCreerTheme() { this.ihm.disposeFrameCreerTheme(); }

    /**
     * Permet de fermer la fenêtre de suppression de thème
     */
    public void disposeFrameSuppTheme() { this.ihm.disposeFrameSuppTheme(); }

    /**
	 * Permet d'ajouter un nouveau thème personnalisé à la menuBarre
     * @param nomTheme : Nom du thème dans la menuBarre
	 */
	public void ajouterThemePersoOnMenuBarre(String nomTheme) { this.ihm.ajouterThemePersoOnMenuBarre(nomTheme); }

    /**
	 * Permet de récupérer la liste des noms des thèmes perso créer par l'utilisateur.
	 * @return List : liste des noms des thèmes perso.
	 */
	public List<String> getLstNameThemesPerso() { return this.metier.getLstNameThemesPerso(); }

    /**
     * Permet de récupérer le nombre de thèmes perso créer par l'utilisateur.
     * @return int : nombre de thèmes perso.
     */
    public int getNbThemesPerso() { return this.metier.getNbThemesPerso(); }

    /**
     * Permet de modifier le nombre de thèmes perso créer par l'utilisateur.
     */
    public void majNbThemesPerso() { this.metier.majNbThemesPerso(); }

    /**
     * Permet de modifier le nom du thème utilisé
     * @param theme : Nom du thème à utiliser
     */
    public void setNomTheme(String theme) { this.metier.setNomTheme(theme); }

    /**
	 * Permet de modifier un élément du thème dans le fichier xml.
	 * @param nameElement : nom de l'élément à modifier.
	 * @param color : nouvelle couleur de l'élément.
	 * @return boolean : true si l'élément a été modifié, false sinon.
	 */
    public boolean setElementTheme(String nomElement, Color couleur) { return this.metier.setElementTheme(nomElement, couleur); }

    /**
     * Permet de supprimer un thème perso.
     * Supprime le fichier du thème perso.
     * Met à jour la liste des noms des thèmes perso.
     * Met à jour le nombre de thèmes perso.
     * Met à jour la menuBarre.
     * @param lstNomsThemes : Liste des noms des thèmes perso à supprimer
     */
    public void supprimerThemePerso(List<String> lstNomsThemes)
    {
        this.metier.supprimerThemePerso(lstNomsThemes);
        this.ihm.supprimerThemePersoOnMenuBarre(lstNomsThemes);
    }

    /**
     * Permet de récupérer la liste des clés de la HashMap contenant les couleurs du thème.
     * @return List : liste des clés
     */
    public String[] getEnsClesThemes() { return this.metier.getEnsClesThemes(); }


    /*==========*/
    /* Langages */
    /*==========*/
    /**
     * Permert de récupérer toute les couleurs de thème charger en mémoire.
     * @return HashMap - liste des couleurs du thème.
     * 
     * object possible dans la hashmap : 
     * 
     * list.get(0) = couleur de fond.
     * list.get(1) = couleur du texte.
     * list.get(2) = couleur de hint / placeHolder (n'existe pas toujours).
     */
    public HashMap<String, HashMap<String, String>> getLangage() { return this.metier.getLangage();}

    /**
     * Change le langage à utilisé dans le fichier de sauvegarde.
     * Charge en mémoire le nouveau langage.
     * Met à jour l'ihm.
     * @param langage : Nom du langage à utiliser
     */
    public void changerLangage(String langage) { this.metier.setLangageUsed(langage); }

    /**
     * Permet de récupérer le nom du langage utilisé
     * @return String : nom du langage utilisé
     */
    public String getLangageUsed() { return this.metier.getLangageUsed(); }

    /**
     * Permet d'appliquer le langage à l'ihm.
     */
    public void appliquerLangage() { this.ihm.appliquerLangage(); }



    /*=====================*/
    /* Gestion des onglets */
    /*=====================*/
    /**
     * Permet d'ajouter un onglet à l'ihm
     */
    public void ajouterOnglet() { this.ihm.ajouterOnglet(); }

    /**
     * Permet de supprimer l'onglet séléctionner dans l'ihm
     */
    public void supprimerOnglet() { this.ihm.supprimerOnglet(); }

    /**
     * Permet de faire le focus sur l'onglet précédent
     */
    public void ongletPrecedent() { this.ihm.ongletPrecedent(); }

    /**
     * Permet de faire le focus sur l'onglet suivant
     */
    public void ongletSuivant() { this.ihm.ongletSuivant(); }

    /**
     * Permet de fermer la fenêtre principale
     */
    public void closeParent() { this.ihm.dispose(); }
    
    /**
     * Permet de renommer un onglet
     * @param nom : Nouveau nom de l'onglet
     */
    public void renameOnglet(String nom) { this.ihm.renameOnglet(nom); }

    /**
     * Permet de récupérer la frame principale (utile pour les JDialog qui doivent connaitre leur parent)
     * @return JFrame : frame principale
     */
    public JFrame getFramePrincipale() { return this.ihm; }
    



    /*==============*/
    /* Arborescence */
    /*==============*/
    /*------------------*/
	/* Méthode générale */
	/*------------------*/
    /**
	 * Permet de convertir un TreePath en File
	 * @param tp : TreePath à convertir
	 * @return File : fichier correspondant au TreePath passé en paramètre
	 */
	public File treePathToFile(TreePath tp) { return this.metier.treePathToFile(tp); }

    /**
     * Ajoute les noeuds fils à un noeud existant
     * @param node le noeud au quel rajouter les noeuds fils
     * @param filePath le chemin absolut du dossier à ajouter
     */
    public void addNode(DefaultMutableTreeNode node, String filePath)
    {
        this.ihm.addNode(node, filePath);
    }

    /**
     * Permet de supprimer un noeud de l'arborescence
     * @param node : noeud à supprimer
     * @param filePath : chemin absolut du fichier ou du dossier à supprimer
     */
    public void removeNode(DefaultMutableTreeNode node, String filePath)
    {
        this.ihm.removeNode(node, filePath);
    }

    /**
     * Permet de récupérer l'arborescence
     * @return Explorer : arborescence
     */
    public Explorer getArborescence(String panel) { return this.ihm.getArborescence(panel); }


    /*-------------------------------*/
	/* Méthode panel fonction global */
	/*-------------------------------*/
    /**
     * Permet de comparer deux éléments de l'arborescence (fichier ou dossier)
     * @param fileGauche : fichier provenant de l'arborescence de gauche
     * @param fileDroite : fichier provenant de l'arborescence de droite
     * @return boolean : true si les deux élément sont identiques, sinon false
     */
    public boolean comparer(File fileGauche, File fileDroite) { return this.metier.comparer(fileGauche, fileDroite); }


    /*----------------*/
	/* FolderListener */
	/*----------------*/
    /**
     * Permet de lire les évènements d'un dossier
     * @param filePath : chemin absolut du dossier à écouter
     */
    public void addFolderListener(String filePath) { this.metier.addFolderListener(filePath); }

    /**
     * Permet de supprimer les écouteurs d'évènements d'un dossier
     * @param filePath : chemin absolut du dossier à écouter
     */
    public void removeFolderListener(String filePath) { this.metier.removeFolderListener(filePath); }


    /*--------------------*/
	/* Option click droit */
	/*--------------------*/
    /**
     * Permet de changer la racine de l'arborescence
     * @param arborescence : arborescence sur le quel changer la racine (le lecteur)
     * @return boolean : true si le changement à réussi, sinon false
     */
    public boolean changeDrive(Explorer arborescence) { return this.metier.changeDrive(arborescence); }

    /**
     * Permet d'ouvrire le fichier (ou le dossier) passé en paramètre
     * @param arborescence : arborescence dans le quel ouvrir le dossier
     * @param fileToOpen : fichier à ouvrir
     * @return boolean : true si l'ouverture à réussi, sinon false
     */
    public boolean open(File fileToOpen) { return this.metier.open(fileToOpen); }

    /**
     * Permet de renommer un fichier ou un dossier
     * @param arborescence : arborescence dans le quel renommer le fichier ou le dossier
     * @param fileToRename : fichier ou dossier à renommer
     * @return boolean : true si le renommage à réussi, sinon false
     */
    public boolean rename(Explorer arborescence, File fileToRename) { return this.metier.rename(arborescence, fileToRename); }

    /**
     * Permet de créer un nouvelle élements (fichier ou dossier)
     * @param arborescence : arborescence dans le quel créer l'élement
     * @param folderDestination : dossier dans le quel créer l'élement
	 * @param type : 0 pour un fichier, 1 pour un dossier
     * @return boolean : true si la création à réussi, sinon false
     */
    public boolean newElement(Explorer arborescence, File folderDestination, int type) { return this.metier.newElement(arborescence, folderDestination, type); }

    /**
     * Permet de supprimer un fichier ou un dossier (ainsi que tout son contenu)
     * @param arborescence : arborescence dans le quel se trouve le fichier ou le dossier à supprimer
     * @param fileToDelete : fichier ou dossier à supprimer
     * @return boolean : true si la suppression à réussi, sinon false
     */
    public boolean delete(Explorer arborescence, File fileToDelete) { return this.metier.delete(arborescence, fileToDelete); }

    /**
     * Permet de copier un fichier ou un dossier (ainsi que tout les dossiers et fichiers qu'il contient).
     * Copie le fichier ou le dossier dans le dossier dans le press-papier, donc il peut être coller dans une autre application.
     * @param arborescence : arborescence dans le quel se trouve le fichier ou le dossier à copier
     * @param fileToCopy : fichier ou dossier à copier
     * @return boolean : true si la copie à réussi, sinon false
     */
    public boolean copy(Explorer arborescence, File fileToCopy) { return this.metier.copy(arborescence, fileToCopy); }

    /**
     * Permet de copier le chemin absolut d'un fichier ou d'un dossier.
     * @param pathToCopy : chemin absolut du fichier ou du dossier à copier
     * @return boolean : true si la copie à réussi, sinon false
     */
    public boolean copyPath(String pathToCopy) { return this.metier.copyPath(pathToCopy); }

    /**
     * Permet de couper un fichier ou un dossier (ainsi que tout les dossiers et fichiers qu'il contient).
     * Couper un fichier ou un dossier revient à le copier puis à le supprimer.
     * @param arborescence : arborescence dans le quel se trouve le fichier ou le dossier à couper
     * @param filToCut : fichier ou dossier à couper
     * @return boolean : true si le coupage à réussi, sinon false
     */
    public boolean cut(Explorer arborescence, File filToCut) { return this.metier.cut(arborescence, filToCut); }

    /**
     * Permet de coller un fichier ou un dossier (ainsi que tout les dossiers et fichiers qu'il contient).
     * Le fichier ou le dossier à coller est celui qui est présent dans le presse-papier donc peux avoir été copier depuis une autre application.
     * @param arborescence : arborescence dans le quel se trouve le dossier de destination
     * @param folderDestination : dossier dans le quel coller le fichier ou le dossier
     * @return boolean : true si le collage à réussi, sinon false
     */
    public boolean paste(Explorer arborescence, File folderDestination) { return this.metier.paste(arborescence, folderDestination); }

    /**
     * Permet d'fficher une fenêtre de dialogue avec tout les propriétés d'un fichier ou d'un dossier.
     * @param fileToGetProperties : fichier ou dossier dont on veut afficher les propriétés
     */
    public void properties(File fileToGetProperties) { this.metier.properties(fileToGetProperties); }



    /*========*/
    /* Autres */
    /*========*/






    /*======*/
    /* Main */
    /*======*/
    public static void main(String[] args)
    {
        new Controleur();
    }
}