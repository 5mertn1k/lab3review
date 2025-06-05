/* Продолжение задания №6 */

package ru.seduhin.main;
import ru.seduhin.weapons.Weapon;

/**
 * Класс стрелка, использующего оружие
 */
class Shooter {
    private String name;
    private Weapon weapon;

    /**
     * Устанавливает новое имя
     * @param name имя стрелка
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Устанавливает новое оружие
     * @param weapon оружие
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Создает стрелка с указанным именем и оружием
     * @param name имя стрелка
     * @param weapon оружие (может быть null)
     */
    public Shooter(String name, Weapon weapon) {
        this.name = name;
        this.weapon=weapon;
    }


    /**
     * Производит выстрел из оружия стрелка
     */
    public void shoot() {
        if (weapon != null) {
            System.out.println(name + " стреляет: ");
            weapon.shoot();
        } else {
            System.out.println(name + ": не могу участвовать в перестрелке");
        }
    }
}
