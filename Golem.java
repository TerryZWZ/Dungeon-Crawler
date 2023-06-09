class Golem extends Monster {
  protected int xp = 0;
  protected String myItem = "Defence Buff";

  Golem() {
    this.name = "Golem";
    this.baseHealth = 110;
    this.baseMana = 0;
    this.baseDamage = 10;
    this.health = 110;
    this.mana = 0;
    this.damage = 10;
    this.level = 0;
    this.damageDF = 3;
    this.manaDF = 3;
    this.isDefended = false;
    this.difficulty = 1;
  }

  Golem(int difficulty) {
    int x = 1 + (difficulty / 10);
    this.difficulty = difficulty;
    this.name = "Golem";
    this.baseHealth = 110 * x;
    this.baseMana = 0 * x;
    this.baseDamage = 10 * x;
    this.health = 110 * x;
    this.mana = 0 * x;
    this.damage = 10 * x;
    this.level = 0 * x;
    this.damageDF = 3 * x;
    this.manaDF = 3 * x;
    this.isDefended = false;
  }

  public String attack(Entity enemy, boolean defending) {
    enemy.defend(this.damage, this.mana, defending);
    this.xp += 25;
    return "";
  }

  public String monsterDefend(int meleeDMG, int magicDMG) {
    float h = this.health - (meleeDMG / this.damageDF) - (magicDMG / this.manaDF);
    this.health = (int) h;

    if (this.isAlive()) {
      return "";
    }
    
    else {
      return this.myItem;
    }
  }

  public void levelUp() {
    if (xp >= 50) {
      level += 1;
      this.baseHealth += 10;
      this.baseMana += 10;
      this.baseDamage += 10;
      xp = 0;
    }
  }

  public void heal() {
    if (health < baseHealth) {
      health += 15;
    }
  }

  public void heal(String partyMember) {

  }

  public boolean isAlive() {
    if (health <= 0) {
      return false;
    }
    
    return true;
  }
}