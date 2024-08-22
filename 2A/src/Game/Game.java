package Game;

public class Game {
	    public static void main(String[] args) {
	        GameState gameState = GameState.getInstance();
	        gameState.setLevel(1);
	        gameState.setDifficulty("Easy");

	        EnemyFactory enemyFactory;
	        GameItemFactory itemFactory;

	        if (gameState.getDifficulty().equals("Easy")) {
	            enemyFactory = new EasyEnemyFactory();
	            itemFactory = new EasyLevelFactory();
	        } else {
	            enemyFactory = new HardEnemyFactory();
	            itemFactory = new HardLevelFactory();
	        }

	        Enemy enemy = enemyFactory.createEnemy();
	        Weapon weapon = itemFactory.createWeapon();
	        PowerUp powerUp = itemFactory.createPowerUp();

	        enemy.attack();
	        weapon.use();
	        powerUp.activate();
	        
	        
	    }


}
