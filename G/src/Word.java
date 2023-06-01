import java.util.*;

class RandomWordGenerator {
    public String getRandomWord() {
        String[] WORDS = {"Apple", "Beach", "Brain", "Bread", "Brush", "Chair", "Chest", "Chord", "Click", "Clock", "Cloud", "Dance", "Diary", "Drink", "Earth", "Flute", "Fruit", "Ghost", "Grape", "Green", "Happy", "Heart", "House", "Juice", "Light", "Money", "Party", "Pizza", "River", "Radio", "Sheep", "Smile", "Snack", "Snake", "Spice", "Storm", "Table", "Toast", "Tiger", "Train", "Water", "Tiger", "Woman", "World", "Write", "Youth", "Abyss", "Ample", "Ankle", "Brisk", "Clasp", "Drape", "Elite", "Flair", "Gloom", "Haste", "Ivory", "Joust", "Knead", "Mourn", "Nanny", "Olive", "Poise", "Quake", "Ravel", "Swish", "Tonic", "Tweak"};
        Random rand = new Random();
        int randomInt = (int)(Math.random()*WORDS.length);
        String temp = WORDS[randomInt];
        return temp;
    }
}
