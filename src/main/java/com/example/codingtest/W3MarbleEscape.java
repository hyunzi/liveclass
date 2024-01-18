package com.example.codingtest;

import java.util.Arrays;
import java.util.Scanner;

public class W3MarbleEscape {

    /*https://www.acmicpc.net/problem/13459*/

    public static void main(String args[]) {

        // 빨간구슬이랑 파란구슬의 최단거리를 구해서 비교하면 되는 것 아닐까?
        // 빨간구슬의 최단거리를 구하며, 파란 구슬을 똑같이 움직였을 때, 겹치거나 먼저 빠져나가는지 검사해야할듯?
        // 음... 꼭 최단거리여야 할까 그냥 이동하는 방법 중에 파란구슬이 도달하기 전이기만 하면 되지 않을까?

        /* 1. 데이터 입력 받기 */
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int rowLength = Integer.parseInt(str.split(" ")[0]);
        int colLength = Integer.parseInt(str.split(" ")[1]);
        char[][] graph = new char[rowLength][colLength];
        int[] red = {};
        int[] blue = {};
        int[] exit = {};
        for (int i = 0; i < rowLength; i++) {
            char[] lineArr = sc.nextLine().toCharArray();
            for (int j = 0; j < lineArr.length; j++) {
                graph[i][j] = lineArr[j];
                if (lineArr[j] == 'R') {
                    red = new int[]{i,j};
                } else if (lineArr[j] == 'B') {
                    blue = new int[]{i,j};
                } else if (lineArr[j] == 'O') {
                    exit = new int[]{i,j};
                }
            }
        }

        /* 2. 빨간구슬 좌표에서 구멍 좌표로 이동하는 거리 구하기 - DFS 탐색 */
        /* 한 번에 기울인 방향의 . 으로는 쭉 이동할 수 있음! */
        //빨간구슬 상하좌우에 . 이 있는 곳을 발견
        //그 방향으로 빨간구슬 먼저 모두 보낸 후, 파란구슬을 빨간구슬 앞 또는 장애물 앞까지 보냄
        //파란구슬이 구멍에 도달하거나 10회 이상이 걸리면 0을 리턴한다

        int count = 0;
        int[] dr = {-1, 1, 0, 0}; //상, 하, 좌, 우
        int[] dc = {0, 0, -1, 1};
        System.out.println(Arrays.toString(red));
        System.out.println(Arrays.toString(blue));
        System.out.println(Arrays.toString(exit));
        while (count < 10) {
            for (int i = 0; i < dr.length; i++) {
                int redR = red[0] + dr[i];
                int redC = red[1] + dc[i];
                if (redR > 0 && redR < graph.length-1 && redC > 0 && redC < graph[0].length) {
                    if (graph[redR][redC] == '.') {
                        //이동할 방향을 찾았음
                        while (graph[redR][redC] == '.') {
                            redR = redR+dr[i];
                            redC = redC+dc[i];
                        }

                        int blueR = blue[0] + dr[i];
                        int blueC = blue[1] + dc[i];
                        while (graph[blueR][blueC] == '.') {
                            blueR = blueR+dr[i];
                            blueC = blueC+dc[i];
                        }
                        red[0] = redR; red[1] = redC; blue[0] = blueR; blue[1] = blueC;
                        System.out.println("red: "+Arrays.toString(red));
                        System.out.println("blue: "+Arrays.toString(blue));
                        count++;
                        break;
                    }
                }
            }
            //방향만 가지고 나와서 DFS
            //빨강의 visited 를 바꿔서 다음 좌표 구하기 -> red도 옮김

            //파랑의 visited 를 바꿔서 다음 좌표 구하기 -> blue도 옮김

        }




    }

}
