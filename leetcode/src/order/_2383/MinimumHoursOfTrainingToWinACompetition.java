package order._2383;

/**
 * 赢得比赛需要的最少训练时长
 * 你正在参加一场比赛，给你两个 正 整数 initialEnergy 和 initialExperience 分别表示你的初始精力和初始经验。
 *
 * 另给你两个下标从 0 开始的整数数组 energy 和 experience，长度均为 n 。
 *
 * 你将会 依次 对上 n 个对手。第 i 个对手的精力和经验分别用 energy[i] 和 experience[i] 表示。当你对上对手时，需要在经验和精力上都 严格 超过对手才能击败他们，然后在可能的情况下继续对上下一个对手。
 *
 * 击败第 i 个对手会使你的经验 增加 experience[i]，但会将你的精力 减少  energy[i] 。
 *
 * 在开始比赛前，你可以训练几个小时。每训练一个小时，你可以选择将增加经验增加 1 或者 将精力增加 1 。
 *
 * 返回击败全部 n 个对手需要训练的 最少 小时数目。
 *
 * 示例 1：
 *
 * 输入：initialEnergy = 5, initialExperience = 3, energy = [1,4,3,2], experience = [2,6,3,1]
 * 输出：8
 * 解释：在 6 小时训练后，你可以将精力提高到 11 ，并且再训练 2 个小时将经验提高到 5 。
 * 按以下顺序与对手比赛：
 * - 你的精力与经验都超过第 0 个对手，所以获胜。
 *   精力变为：11 - 1 = 10 ，经验变为：5 + 2 = 7 。
 * - 你的精力与经验都超过第 1 个对手，所以获胜。
 *   精力变为：10 - 4 = 6 ，经验变为：7 + 6 = 13 。
 * - 你的精力与经验都超过第 2 个对手，所以获胜。
 *   精力变为：6 - 3 = 3 ，经验变为：13 + 3 = 16 。
 * - 你的精力与经验都超过第 3 个对手，所以获胜。
 *   精力变为：3 - 2 = 1 ，经验变为：16 + 1 = 17 。
 * 在比赛前进行了 8 小时训练，所以返回 8 。
 * 可以证明不存在更小的答案。
 *
 * @author tengxq
 */
public class MinimumHoursOfTrainingToWinACompetition {

    public static void main(String[] args) {
        System.out.println(new MinimumHoursOfTrainingToWinACompetition().minNumberOfHours(1,1, new int[]{1,1,1,1}, new int[]{1,1,1,50}));
    }

    /**
     * 思路，此题像是系统资源为程序依次分配CPU资源的场景
     * 从第一个开始，依次算出需要最小的精力值和经验值
     * 最后分别后减去初始化精力值与经验值，得到的和即为训练时长
     *
     * @param initialEnergy 初始精力
     * @param initialExperience 初始经验
     * @param energy 对手精力值数组
     * @param experience 对手经验值数组
     * @return 最小训练时长
     */
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        // 计算精力值
        int minEnergy = 0;
        for (int i = 0; i < energy.length; i++) {
            // 需要进行训练
            if (initialEnergy <= energy[i]) {
                int trainHours = energy[i] - initialEnergy + 1;
                minEnergy += trainHours;
                initialEnergy += trainHours;
            }
            initialEnergy-=energy[i];
        }
        // 计算经验值
        int minExperience = 0;
        for (int i = 0; i < experience.length; i++) {
            // 需要进行训练
            if (initialExperience <= experience[i]) {
                int trainHours = experience[i] - initialExperience + 1;
                minExperience += trainHours;
                initialExperience += trainHours;
            }
            initialExperience += experience[i];
        }
        return minEnergy +minExperience;
    }

    /**
     * 思路，此题像是系统资源为程序依次分配CPU资源的场景
     * 从第一个开始，依次算出需要最小的精力值和经验值
     * 最后分别后减去初始化精力值与经验值，得到的和即为训练时长
     *
     * @param initialEnergy 初始精力
     * @param initialExperience 初始经验
     * @param energy 对手精力值数组
     * @param experience 对手经验值数组
     * @return 最小训练时长
     */
    public int minNumberOfHours2(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        // 计算精力值
        int minEnergy = 0;
        int minExperience = 0;
        for (int i = 0; i < energy.length; i++) {
            // 精力值不够 需要进行训练
            if (initialEnergy <= energy[i]) {
                int trainHours = energy[i] - initialEnergy + 1;
                minEnergy += trainHours;
                initialEnergy += trainHours;
            }
            initialEnergy-=energy[i];

            // 经验值不够 需要进行训练
            if (initialExperience <= experience[i]) {
                int trainHours = experience[i] - initialExperience + 1;
                minExperience += trainHours;
                initialExperience += trainHours;
            }
            initialExperience += experience[i];
        }
        return minEnergy +minExperience;
    }
}
