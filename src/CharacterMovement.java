public class CharacterMovement {
    private Character character;
    private boolean jumping;
    private int jumpHeight;
    private int jumpSpeed;
    private int groundLevel;
    private int panelWidth;
    private boolean falling = false;

    public CharacterMovement(Character character, int jumpHeight, int jumpSpeed, int groundLevel, int panelWidth) {
        this.character = character;
        this.jumping = false;
        this.jumpHeight = jumpHeight;
        this.jumpSpeed = jumpSpeed;
        this.groundLevel = groundLevel;
        this.panelWidth = panelWidth;
    }
    public void moveForward() {
        if (character.x + character.speed + 50 <= panelWidth) {
            character.moveForward();
        }
    }
    public void moveBackward() {
        if (character.x - character.speed >= -48) {
            character.moveBackward();
        }
    }
    public void startJump() {
        if (!jumping) {
            jumping = true;
            falling = false;
        }
    }
    public void updateJump() {
        if (jumping) {
            if (character.getY() > jumpHeight && !falling) {
                character.setY(character.getY() - jumpSpeed); // Karakter naik
                if (character.getY() <= jumpHeight) {
                    falling = true; // Setelah mencapai ketinggian maksimum, mulai turun
                }
            } else {
                character.setY(character.getY() + jumpSpeed); // Karakter turun
                if (character.getY() >= groundLevel) {
                    character.setY(groundLevel); // Kembalikan karakter ke posisi awal setelah melompat
                    jumping = false;
                    falling = false;
                }
            }
        }
    }
    public void usSk() {
        character.moveUp();
    }
}
