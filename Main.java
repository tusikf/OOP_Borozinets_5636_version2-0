//Проанализировать персонажей "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах".
//Для каждого определит 8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд).
//Создать абстрактный класс и иерархию наследников.
//Расположить классы в пакет так, чтобы в основной программе небыло видно их полей.
//В не абстрактных классах переопределить метод toString() так чтобы он возвращал название класса или имя.
//Создать в основной программе по одному обьекту каждого не абстрактного класса и вывести в консоль его имя.
//Формат сдачи:
//Ссылка на гитхаб проект
//Подписать фамилию и номер группы


import units.*;

import java.util.*;

public class Main {
    public static ArrayList<Unit> holyTeam = new ArrayList<>();
    public static ArrayList<Unit> darkTeam = new ArrayList<>();
    public static ArrayList<Unit> allTeam = new ArrayList<>();
    public static void main(String[] args) {
        Random random = new Random();

        // Заполняем команды рандомом. Метод init
        init();



        // Вывод полного списка команд, чтобы посмотреть, как сработал рандом.
        System.out.println("Команда № 1:");
        for (Unit a : holyTeam){
            a.printShort();

        }
        System.out.println("Команда № 2:");
        for (Unit a : darkTeam){
            a.printShort();
        }


        allTeam.addAll(holyTeam);
        allTeam.addAll(darkTeam);
        allTeam.sort((o1, o2) -> o2.getSpeed() - o1.getSpeed());

        //allTeam.forEach(n-> n.printShort());
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (true) {

            View.view();
            scanner.nextLine();
            int summ1HP = 0;
            int summ2HP = 0;
            for (Unit unit : holyTeam){
                summ1HP += unit.getHp();
            }
            for (Unit unit : darkTeam){
                summ2HP += unit.getHp();
            }
            if (summ1HP == 0){
                System.out.println("Победила команда darkTeam");
                flag = false;
                break;
            }
            if (summ2HP == 0){
                System.out.println("Победила команда holyTeam");
                flag = false;
                break;
            }
            for (Unit unit : allTeam) {
                if (holyTeam.contains(unit)) unit.step(darkTeam, holyTeam);
                else unit.step(holyTeam, darkTeam);
            }

        }
    }





    private static String getName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length-1)]);
    }

    public static void init(){
        Random random = new Random();
        int teamcount = 10;
        for (int i = 1; i < teamcount+1; i++) {
            int val = random.nextInt(7);
            int coordX1 = random.nextInt(10);
            int coordX2 = random.nextInt(10);
            Position xy1 = new Position(coordX1, 1);
            Position xy2 = new Position(coordX2, 10);
            System.out.println(xy1);
            switch (val) {
                case 0:
                    holyTeam.add(new Crossbowman(getName(), i,1));
                    break;
                case 1:
                    holyTeam.add(new Mag(getName(), i,1));

                    break;
                case 2:
                    holyTeam.add(new Monk(getName(),i,1));

                    break;
                case 3:
                    holyTeam.add(new Outlaw(getName(), i,1));

                    break;
                case 4:
                    holyTeam.add(new Peasant(getName(), i,1));

                    break;
                case 5:
                    holyTeam.add(new Sniper(getName(), i,1));

                    break;
                case 6:
                    holyTeam.add(new Spearman(getName(), i,1));

                    break;
            }
        }
        for (int i = 1; i < teamcount+1; i++) {
            int val = random.nextInt(7);
            int coordX1 = random.nextInt(10);
            int coordX2 = random.nextInt(10);
            Position xy1 = new Position(coordX1, 1);
            Position xy2 = new Position(coordX2, 10);
            System.out.println(xy1);
            switch (val) {
                case 0:

                    darkTeam.add(new Crossbowman(getName(), i,10));
                    break;
                case 1:

                    darkTeam.add(new Mag(getName(), i,10));
                    break;
                case 2:

                    darkTeam.add(new Monk(getName(), i,10));
                    break;
                case 3:

                    darkTeam.add(new Outlaw(getName(), i,10));
                    break;
                case 4:

                    darkTeam.add(new Peasant(getName(), i,10));
                    break;
                case 5:

                    darkTeam.add(new Sniper(getName(), i,10));
                    break;
                case 6:

                    darkTeam.add(new Spearman(getName(), i,10));
                    break;
            }
        }
    }
}
