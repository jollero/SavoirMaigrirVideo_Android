package anxa.com.smvideo.util;

/**
 * Created by allenanxa on 5/26/2017.
 */

public class BilanMinceurUtil {
    private String dQuestions [] = {
            "Quel délai vous paraît raisonnable pour perdre vos kilos en trop et atteindre votre objectif avec le programme Savoir Maigrir ?",
            "De combien de temps disposez-vous par jour pour préparer vos repas et ceux du foyer ?",
            "Comment décririez-vous vos habitudes alimentaires ?",
            "Quel type d'excès ou d'écarts faites-vous le plus souvent ?",
            "Où avez-vous le plus tendance à stocker vos kilos ?",
            "Qu'est-ce qui, aujourd'hui, vous motive pour perdre enfin vos kilos en trop ?",
            "Différents profils sont maintenant pris en compte dans la nouvelle formule Savoir Maigrir : lequel se rapproche le plus du vôtre ?",
            "Avez-vous déjà entendu parler du Jeûne Cohen 16h ?",
            "D'après vous, laquelle de ces caractéristiques de Savoir Maigrir vous aidera le plus à atteindre votre objectif minceur ?",
            "Pour réussir, combien de temps êtes-vous prêt(e) à accorder quotidiennement à votre programme ?"
    };

    private  String dOptions [][] = {
            {"Moins d'1 mois", "Entre 1 et 3 mois", "Entre 3 et 6 mois", "Plus de 6 mois"},
            {"Je n'ai pas le temps de cuisiner", "Moins de 30 minutes", "Entre 30 minutes et 1 heure", "Plus d'1 heure"},
            {"Il m'arrive de sauter l'un des 3 repas", "Je prends des repas aussi variés et équilibrés que possible", "Je mange souvent des sandwiches, pizzas ou du fast-food", "Je suis plutôt steak frites et plats cuisinés", "Je mange peu de viande, de poisson et d'&#339;ufs et beaucoup de fruits et légumes", "Je suis végétarienne ou je dois suivre un régime spécifique"},
            {"Je grignote très souvent", "Je mange en trop grande quantité", "Je mange sans cesse à l'extérieur, au restaurant" , "Je privilégie les plats riches en matières grasses ou très sucrés", "Non, rien de tout cela"},
            {"le ventre et les hanches", "les fesses et les cuisses", "les bras et les épaules", "tout le corps"},
            {"Me sentir mieux dans ma peau et retrouver confiance en moi", "Retrouver du tonus et mes capacités physiques", "Refléter la véritable image que j'ai de moi-même", "Plaire d'avantage, à moi-même et aussi aux autres !", "Prendre soin de ma santé et de mon équilibre de vie", "Réapprendre à bien manger et à cuisiner sainement", "Autres"},
            {"Classique, je n'ai pas de besoin spécial ou d'exigence particulière", "Je suis végétarien(ne)", "Je préfère éviter tout type ou certains types de laitages", "Je ne prends jamais de petit-déjeuner", "Je suis une alimentation sans gluten", "Je ne mange pas de porc", "Je souffre de colopathie/intestin irritable", "Aucun, je ferai appel à l'équipe des diététiciennes de Savoir Maigrir pour qu'elle personnalise mon programme" },
            {"Oui, je connais bien son principe d'accélérateur de perte de poids", "Oui, j'ai vu que cela pouvait me faire perdre 3 kilos de plus mais je ne connais pas tous les détails de sa mise en place", "Non, jamais entendu parler" },
            {"Avoir tout déjà prêt : menus, plans repas, recettes et listes de courses à imprimer", "Pouvoir manger varié et équilibrer ma nourriture afin d'éviter toute frustration", "Le suivi diététique personnalisé pour adapter le programme à mes goûts, besoins et style de vie", "Les conseils vidéos quotidiens de Jean-Michel Cohen", "L'appui de la communauté et des animateurs du programme pour toujours être accompagnée", "Tous les avantages mentionnés ci-dessus !"},
            {"5 minutes", "Entre 5 et 15 minutes", "Entre 15  et 30 mn", "Plus de 30 mn"}
    };

    public String getQuestion(int q){
        String question = dQuestions[q];
        return  question;
    }

    public String[] getOptions(int o) {
        String[] options = dOptions[o];
        return options;
    }
}


