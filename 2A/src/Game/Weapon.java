package Game;

	abstract class Weapon {
	    public abstract void use();
	}

	class Sword extends Weapon {
	    @Override
	    public void use() {
	        System.out.println("Swinging a sword!");
	    }
	}

	class Gun extends Weapon {
	    @Override
	    public void use() {
	        System.out.println("Shooting a gun!");
	    }
	}

	abstract class PowerUp {
	    public abstract void activate();
	}

	class HealthBoost extends PowerUp {
	    @Override
	    public void activate() {
	        System.out.println("Health boost activated!");
	    }
	}

	class SpeedBoost extends PowerUp {
	    @Override
	    public void activate() {
	        System.out.println("Speed boost activated!");
	    }
	}

	abstract class GameItemFactory {
	    public abstract Weapon createWeapon();
	    public abstract PowerUp createPowerUp();
	}

	class EasyLevelFactory extends GameItemFactory {
	    @Override
	    public Weapon createWeapon() {
	        return new Sword();
	    }

	    @Override
	    public PowerUp createPowerUp() {
	        return new HealthBoost();
	    }
	}

	class HardLevelFactory extends GameItemFactory {
	    @Override
	    public Weapon createWeapon() {
	        return new Gun();
	    }

	    @Override
	    public PowerUp createPowerUp() {
	        return new SpeedBoost();
	    }

}
