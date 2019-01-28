package com.unrealdinnerbone.leathercows.util;

import java.util.Random;

public class MathHelper
{
    public static int getRandomInt(Random random, int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
