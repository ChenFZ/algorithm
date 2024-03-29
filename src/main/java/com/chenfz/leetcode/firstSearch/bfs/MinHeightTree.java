/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: MinHeightTree
 * Author:   chenfz
 * Date:     2021/8/29 10:12
 * Description: 最小高度树
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.firstSearch.bfs;

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈最小高度树〉
 *
 * 出度可以写作度就可以了吧 无向图用度表示就行，不然一开始看有一点疑惑
 * @author chenfz
 * @create 2021/8/29
 * @since 1.0.0
 */
public class MinHeightTree {
    public static void main(String[] args) {
        MinHeightTree minHeightTree = new MinHeightTree();
        //int[][] edges = {{0,1},{1,2},{2,3},{3,4},{4,5},{5,6},{6,7},{7,8},{8,9},{9,10},{10,11},{11,12},{12,13},{13,14},{14,15},{15,16},{16,17},{17,18},{18,19},{19,20},{20,21},{21,22},{22,23},{23,24},{24,25},{25,26},{26,27},{27,28},{28,29},{29,30},{30,31},{31,32},{32,33},{33,34},{34,35},{35,36},{36,37},{37,38},{38,39},{39,40},{40,41},{41,42},{42,43},{43,44},{44,45},{45,46},{46,47},{47,48},{48,49},{49,50},{50,51},{51,52},{52,53},{53,54},{54,55},{55,56},{56,57},{57,58},{58,59},{59,60},{60,61},{61,62},{62,63},{63,64},{64,65},{65,66},{66,67},{67,68},{68,69},{69,70},{70,71},{71,72},{72,73},{73,74},{74,75},{75,76},{76,77},{77,78},{78,79},{79,80},{80,81},{81,82},{82,83},{83,84},{84,85},{85,86},{86,87},{87,88},{88,89},{89,90},{90,91},{91,92},{92,93},{93,94},{94,95},{95,96},{96,97},{97,98},{98,99},{99,100},{100,101},{101,102},{102,103},{103,104},{104,105},{105,106},{106,107},{107,108},{108,109},{109,110},{110,111},{111,112},{112,113},{113,114},{114,115},{115,116},{116,117},{117,118},{118,119},{119,120},{120,121},{121,122},{122,123},{123,124},{124,125},{125,126},{126,127},{127,128},{128,129},{129,130},{130,131},{131,132},{132,133},{133,134},{134,135},{135,136},{136,137},{137,138},{138,139},{139,140},{140,141},{141,142},{142,143},{143,144},{144,145},{145,146},{146,147},{147,148},{148,149},{149,150},{150,151},{151,152},{152,153},{153,154},{154,155},{155,156},{156,157},{157,158},{158,159},{159,160},{160,161},{161,162},{162,163},{163,164},{164,165},{165,166},{166,167},{167,168},{168,169},{169,170},{170,171},{171,172},{172,173},{173,174},{174,175},{175,176},{176,177},{177,178},{178,179},{179,180},{180,181},{181,182},{182,183},{183,184},{184,185},{185,186},{186,187},{187,188},{188,189},{189,190},{190,191},{191,192},{192,193},{193,194},{194,195},{195,196},{196,197},{197,198},{198,199},{199,200},{200,201},{201,202},{202,203},{203,204},{204,205},{205,206},{206,207},{207,208},{208,209},{209,210},{210,211},{211,212},{212,213},{213,214},{214,215},{215,216},{216,217},{217,218},{218,219},{219,220},{220,221},{221,222},{222,223},{223,224},{224,225},{225,226},{226,227},{227,228},{228,229},{229,230},{230,231},{231,232},{232,233},{233,234},{234,235},{235,236},{236,237},{237,238},{238,239},{239,240},{240,241},{241,242},{242,243},{243,244},{244,245},{245,246},{246,247},{247,248},{248,249},{249,250},{250,251},{251,252},{252,253},{253,254},{254,255},{255,256},{256,257},{257,258},{258,259},{259,260},{260,261},{261,262},{262,263},{263,264},{264,265},{265,266},{266,267},{267,268},{268,269},{269,270},{270,271},{271,272},{272,273},{273,274},{274,275},{275,276},{276,277},{277,278},{278,279},{279,280},{280,281},{281,282},{282,283},{283,284},{284,285},{285,286},{286,287},{287,288},{288,289},{289,290},{290,291},{291,292},{292,293},{293,294},{294,295},{295,296},{296,297},{297,298},{298,299},{299,300},{300,301},{301,302},{302,303},{303,304},{304,305},{305,306},{306,307},{307,308},{308,309},{309,310},{310,311},{311,312},{312,313},{313,314},{314,315},{315,316},{316,317},{317,318},{318,319},{319,320},{320,321},{321,322},{322,323},{323,324},{324,325},{325,326},{326,327},{327,328},{328,329},{329,330},{330,331},{331,332},{332,333},{333,334},{334,335},{335,336},{336,337},{337,338},{338,339},{339,340},{340,341},{341,342},{342,343},{343,344},{344,345},{345,346},{346,347},{347,348},{348,349},{349,350},{350,351},{351,352},{352,353},{353,354},{354,355},{355,356},{356,357},{357,358},{358,359},{359,360},{360,361},{361,362},{362,363},{363,364},{364,365},{365,366},{366,367},{367,368},{368,369},{369,370},{370,371},{371,372},{372,373},{373,374},{374,375},{375,376},{376,377},{377,378},{378,379},{379,380},{380,381},{381,382},{382,383},{383,384},{384,385},{385,386},{386,387},{387,388},{388,389},{389,390},{390,391},{391,392},{392,393},{393,394},{394,395},{395,396},{396,397},{397,398},{398,399},{399,400},{400,401},{401,402},{402,403}};
        int[][] edges = {};
        List<Integer> list = minHeightTree.findMinHeightTrees(1, edges);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        /*如果只有一个节点，那么他就是最小高度树*/
        if (n == 1) {
            res.add(0);
            return res;
        }
        /*建立各个节点的出度表*/
        int[] degree = new int[n];
        /*建立图关系，在每个节点的list中存储相连节点*/
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;/*出度++*/
            map.get(edge[0]).add(edge[1]);/*添加相邻节点*/
            map.get(edge[1]).add(edge[0]);
        }
        /*建立队列*/
        Queue<Integer> queue = new LinkedList<>();
        /*把所有出度为1的节点，也就是叶子节点入队*/
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.offer(i);
        }
        /*循环条件当然是经典的不空判断*/
        while (!queue.isEmpty()) {
            res = new ArrayList<>();/*这个地方注意，我们每层循环都要new一个新的结果集合，
            这样最后保存的就是最终的最小高度树了*/
            int size = queue.size();/*这是每一层的节点的数量*/
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);/*把当前节点加入结果集，不要有疑问，为什么当前只是叶子节点为什么要加入结果集呢?
                因为我们每次循环都会新建一个list，所以最后保存的就是最后一个状态下的叶子节点，
                这也是很多题解里面所说的剪掉叶子节点的部分，你可以想象一下图，每层遍历完，
                都会把该层（也就是叶子节点层）这一层从队列中移除掉，
                不就相当于把原来的图给剪掉一圈叶子节点，形成一个缩小的新的图吗*/
                List<Integer> neighbors = map.get(cur);
                /*这里就是经典的bfs了，把当前节点的相邻接点都拿出来，
                 * 把它们的出度都减1，因为当前节点已经不存在了，所以，
                 * 它的相邻节点们就有可能变成叶子节点*/
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        /*如果是叶子节点我们就入队*/
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;/*返回最后一次保存的list*/
    }

}
