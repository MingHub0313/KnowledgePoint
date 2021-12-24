package com.zmm.day0702;

/**
 * @Name GuessGame
 * @Author 900045
 * @Created by 2020/7/2 0002
 */
public class GuessGame {

    /**
     * 用三个实例变量分别表示 Player 对象
     */
    Player p1;
    Player p2;
    Player p3;


    public void startGame() {
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        // 声明三个变量来保存猜测的数字
        int guessOne = 0;
        int guessTwo = 0;
        int guessThree = 0;


        // 声明3个变量来保存是否猜中
        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;

        int targetNumber = (int) (Math.random() * 10);
        // 产生谜底数字
        System.out.println("I’m thinking of a number between 0 and 9...");


        while (true) {
            System.out.println("Number to guess is " + targetNumber);
            // 调用 Player的 guess 方法
            p1.guess();
            p2.guess();
            p3.guess();
            // 取得每个 Player 所猜测的数字并将它列出
            guessOne = p1.number;
            System.out.println("Player one guessed " + guessOne);
            guessTwo = p2.number;
            System.out.println("Player two guessed " + guessTwo);
            guessThree = p3.number;
            System.out.println("Player three guessed " + guessThree);

            // 检查是否猜中 若是猜中则去设定是否猜中的变量
            if (guessOne == targetNumber) {
                p1isRight = true;
            }
            if (guessTwo == targetNumber) {
                p2isRight = true;
            }
            if (guessThree == targetNumber) {
                p3isRight = true;
            }
            // 如果有一个 或 多个猜中
            if (p1isRight || p2isRight || p3isRight) {
                System.out.println("We have a winner!");
                System.out.println("Player one got it right? " + p1isRight);
                System.out.println("Player two got it right? " + p2isRight);
                System.out.println("Player three got it right? " + p3isRight);
                System.out.println("Game is over.");
                // 游戏结束 中止循环
                break;
            } else {
                // 都没有猜中 所以要继续下去
                System.out.println("Players will have to try again.");
            }
        }
        // 循环结束
    }
}
