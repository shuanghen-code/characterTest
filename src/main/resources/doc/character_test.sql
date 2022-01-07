/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : character_test

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 10/12/2021 15:18:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_character_question
-- ----------------------------
DROP TABLE IF EXISTS `tbl_character_question`;
CREATE TABLE `tbl_character_question`  (
  `question_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题编号',
  `question` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `option_a` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `option_b` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `option_c` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `option_d` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `type` int(11) NULL DEFAULT 0 COMMENT '预留字段',
  `status` int(11) NULL DEFAULT 0 COMMENT '状态',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `updater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `flag` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '问题表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_character_question
-- ----------------------------
INSERT INTO `tbl_character_question` VALUES (1, '我的人生观是', 'A人生的体验越多越好，所以想法很多，有可能就应该多尝试。', 'B深度比宽度更重要，目标要谨慎，一旦确定就坚持到底。', 'C人生必须有所成。', 'D没必要太辛苦，好好活着就行。', 1, 0, '2021-11-23 11:13:13', 'wang', '2021-12-10 10:13:43', 'wang', 0);
INSERT INTO `tbl_character_question` VALUES (2, '如果野外旅行，在下山返回的路线上，我更在乎：', 'A要好玩有趣，不愿重复，所以宁愿走新路线。', 'B要安全稳妥，担心危险，所以宁愿走原路线。', 'C要挑战自我，喜欢冒险，所以宁愿走新路线。', 'D要方便省心，害怕麻烦，所以宁愿走原路线。', 1, 0, '2021-11-23 11:13:13', 'wang', '2021-11-30 10:29:28', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (3, '在表达一件事情上，别人认为我：', 'A总是给人感受到强烈印象。', 'B总是表述极其准确。', 'C总能围绕最终目的。', 'D总能让大家很舒服。', 1, 0, '2021-11-23 11:13:13', 'chenjian', '2021-11-23 11:13:13', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (4, '在生命多数时候，我其实更希望：', 'A刺激。', 'B安全。', 'C挑战。', 'D稳定。', 1, 0, '2021-11-23 11:13:13', 'chenjian', '2021-11-23 11:13:13', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (5, '我认为自己在情感上的基本特点是：', 'A情绪多变，情绪波动大。', 'B外表抑制强，但内心起伏大，一旦挫伤难以平复。', 'C感情不拖泥带水，较直接。', 'D天性四平八稳。', 1, 0, '2021-11-23 11:13:13', 'chenjian', '2021-11-23 11:13:13', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (6, '我认为自己除了工作以外，在人生的控制欲上，我：', 'A谈不上控制欲，却有强烈地感染带动他人的欲望，但自控能力不强。', 'B用规则来保持我的自控和对他人的要求。', 'C内心有控制欲，希望别人服从我。', 'D从不愿去管别人，也不愿别人来管我。', 1, 0, '2021-11-23 11:13:13', 'chenjian', '2021-11-23 11:13:13', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (7, '当与情人交往时，我倾向于：', 'A在一起时就要尽情地欢乐，爱意常会溢于言表。', 'B体贴入微关怀细腻，于对方的需求和变化极其敏感。', 'C帮助对方成长是我最大的责任。', 'D迁就顺从的陪伴者和绝佳的聆听着。', 1, 0, '2021-11-23 11:13:13', 'chenjian', '2021-11-23 11:13:13', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (8, '在人际交往时，我：', 'A心态开放，可快速建立起人际关系。', 'B非常审慎缓慢地深入，一旦认为是朋友便会长久。', 'C希望在人际关系中占据主导地位。', 'D顺其自然，不温不火，相对被动。', 1, 0, '2021-11-23 11:13:14', 'chenjian', '2021-11-23 11:13:14', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (9, '我认为自己的为人：', 'A可爱而生机。', 'B深沉而内敛。', 'C果断而自信。', 'D平静而和气。', 1, 0, '2021-11-23 11:13:14', 'chenjian', '2021-11-23 11:13:14', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (10, '我完成任务的方式是：', 'A常赶在最后期限前的一刻完成。', 'B自己精确地做，不麻烦别人。', 'C最快速做完，再找下一个任务。', 'D该怎么做就怎么做，需要时从他人处得到帮忙。', 1, 0, '2021-11-23 11:13:14', 'chenjian', '2021-11-23 11:13:14', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (11, '如果有人深深惹恼我，我：', 'A内心手上，当时认为不可能原谅，但最终常会原谅对方。', 'B如此之深的愤怒无法忘记，同时未来避开那个家伙。', 'C每个人都要为他的错误付出相应的代价，内心期望有机会要狠狠的回应。', 'D尽量不摊牌，因为还不到那个地步。', 1, 0, '2021-11-23 11:13:14', 'chenjian', '2021-11-23 11:13:14', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (12, '在人际关系中，我最在意的是：', 'A欢迎。', 'B理解。', 'C尊敬。', 'D接纳。', 1, 0, '2021-11-23 11:13:14', 'chenjian', '2021-11-23 11:13:14', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (13, '在工作上，我表现出更多的是：', 'A热忱，有很多想法且很多灵性。', 'B完美精准且承诺可靠。', 'C坚强而有推动力。', 'D有耐心且适应性强。', 1, 0, '2021-11-23 11:13:14', 'chenjian', '2021-11-23 11:13:14', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (14, '我过往的老师最有可能对我的评价是：', 'A善于表达和抒发情感。', 'B严格保护自己的私密，有时会显得孤独或不合群。', 'C动作敏捷独立，且喜欢自己做事情。', 'D反应度偏低，比较温和。', 1, 0, '2021-11-23 11:13:14', 'chenjian', '2021-11-23 11:13:14', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (15, '朋友对我的评价最有可能的是：', 'A喜欢对朋友倾诉事情，是开心果。', 'B能提出很多问题，且需要许多精细的解说。', 'C解决问题的高手。', 'D总能多听少说。', 1, 0, '2021-11-23 11:13:14', 'chenjian', '2021-11-23 11:13:14', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (16, '在帮助他人的问题上，我倾向于：', 'A我不主动，但若他来找我，那我一定帮。', 'B值得帮助的人就帮。', 'C无关者何必帮，但我若承诺，必完成。', 'D虽无英雄打虎胆，常有自告奋勇心。', 2, 0, '2021-11-23 11:13:14', 'chenjian', '2021-11-23 11:13:14', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (17, '面对他人对自己的赞美，我的本能反应是：', 'A没有赞美也无所谓，得到了也不至于欣喜。', 'B我无须那些没用的赞美，宁可他们欣赏我的能力。', 'C有点怀疑对方是否认真或立即回避很多人的关注。', 'D能得到赞美，总归是一件令人愉悦的事。', 2, 0, '2021-11-23 11:13:15', 'chenjian', '2021-11-23 11:13:15', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (18, '面对生活的现状，我更倾向于：', 'A外面怎样与我无关，我觉得自己这样还行。', 'B这个世界如果我不进步，别人就会进步，所以我需要不停地前进。', 'C在所有的问题未发生前，就该尽量想好所有的可能性。', 'D每天的生活，只要开心快乐最重要。', 2, 0, '2021-11-23 11:13:15', 'chenjian', '2021-11-23 11:13:15', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (19, '对于规则，我内心的态度是：', 'A不愿违反规则，但可能因为松散而无法达到规则要求。', 'B打破规则，希望由自己来制定规则，而不是遵守规则。', 'C严格遵守规则，且竭尽全力做到规则内的最好。', 'D不喜欢被规则束缚，不按规则出牌，会觉得新鲜有趣。', 2, 0, '2021-11-23 11:13:15', 'chenjian', '2021-11-23 11:13:15', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (20, '我认为自己做事上：', 'A慢条斯理，按部就班，能与周围协调一致。', 'B目标明确，集中精力为实现目标而努力，善于抓住核心。', 'C慎重小心，为做好预防及善后，会尽心操劳。', 'D丰富跃动，灵活反应。', 2, 0, '2021-11-23 11:13:15', 'chenjian', '2021-11-23 11:13:15', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (21, '在面对压力时，我比较倾向于选用：', 'A眼不见为净。', 'B压力越大，抵抗力越大。', 'C在自己的内心慢慢地咀嚼消化压力。', 'D本能地回避压力，避不掉就用各种方法发泄出去。', 2, 0, '2021-11-23 11:13:15', 'chenjian', '2021-11-23 11:13:15', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (22, '当结束一段刻骨铭心的感情时，我会：', 'A日子总要过，时间会冲淡一切。', 'B虽然受伤，但一旦下定决心，就会努力把过去的影子甩掉。', 'C深陷悲伤，在相当长的时间里难以自拔，也不愿再接受新的人。', 'D痛不欲生，需要找朋友倾诉，寻求化解之道。', 2, 0, '2021-11-23 11:13:15', 'chenjian', '2021-11-23 11:13:15', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (23, '面对他人的痛苦倾诉，我回顾自己大多数时候本能上倾?', 'A静静地听，认同对方的感受。', 'B作出判断，痛苦没用，要帮助对方解决问题。', 'C给予分析，帮助他分析，安抚他的情绪。', 'D发表自己的评论意见，与对方的情绪共起落。', 2, 0, '2021-11-23 11:13:15', 'wang', '2021-11-23 11:13:15', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (24, '我在以下哪个群体中较感满足？', 'A能心平气和，只要大家达成一致。', 'B能简单扼要有结果地彼此展开充分的辩论。', 'C能就一件事有规则、有条理、有步骤、有章法地详细讨论。', 'D能随意无拘束地、开心地自由谈话。', 2, 0, '2021-11-23 11:13:15', 'chenjian', '2021-11-23 11:13:15', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (25, '我觉得工作：', 'A最好没有压力，让我做我熟悉的工作就不错。', 'B是达成人生目标和成就最重要的途径。', 'C要么不做，要做就做到最好。', 'D如果能将乐趣融合在工作中就太棒了，如果是不喜欢的工作就实在没劲。', 2, 0, '2021-11-23 11:13:15', 'chenjian', '2021-11-23 11:13:15', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (26, '如果我是领导，我内心更希望在部属的心目中，我是：', 'A可以亲近的和善于为他们着想的。', 'B有很强的能力和富有领导力的。', 'C公平公正且足以信赖的。', 'D被他们喜欢并且觉得富有感召力的。', 2, 0, '2021-11-23 11:13:16', 'chenjian', '2021-11-23 11:13:16', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (27, '我希望得到的认同方式是：', 'A有无认同都不要影响我。', 'B精英的认同最重要。', 'C我认同的人或我在乎的人认同即可。', 'D希望大家都能认同我。', 2, 0, '2021-11-23 11:13:16', 'chenjian', '2021-11-23 11:13:16', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (28, '当我还是个孩子时，我：', 'A不太会积极尝试新事物，通常比较喜欢旧有的和熟悉的。', 'B是孩子王，大家经常听我的决定。', 'C害羞见生人，有意识地回避。', 'D调皮可爱，在大部分的情况下是多动且热心的。', 2, 0, '2021-11-23 11:13:16', 'chenjian', '2021-11-23 11:13:16', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (29, '如果我是父母，我也许是：', 'A不愿干涉子女或易被说动的。', 'B严厉的或直接给予方向指点的。', 'C用行动代替语言来表示关爱或高要求的。', 'D愿意陪孩子一起玩，孩子的朋友们所喜欢和欢迎的。', 2, 0, '2021-11-23 11:13:16', 'chenjian', '2021-11-23 11:13:16', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (30, '以下有四组格言，哪组里符合我感觉的数目最多？', 'A最深刻的真理是最简单和最平凡的。\r\n  要在人世间取得成功必定大智如愚。\r\n  好脾气是一个人在社交中所能穿着的最佳服饰。\r\n  知足是人生在世最大的幸福。\r\nA最深刻的真理是最简单和最平凡的。\r\n  要在人世间取得成功必定大智如愚。\r\n  好脾气是一个人在社交中所能穿着的最佳服饰。\r\n  知足是人生在世最大的幸福。\r\nA最深刻的真理是最简单和最平凡的。\r\n  要在人世间取得成功必定大智如愚。\r\n  好脾气是一个人在社交中所能穿着的最佳服饰。\r\n  知足是人生在世最大的幸福。\r\n', 'B走自己的路，让人家去说吧。\r\n  虽然世界充满了苦难，但苦难总能被战胜。\r\n  有所成就是人生唯一的真正的乐趣。\r\n  对我而言，解决一个问题和享受一个假期一样好。\r\n', 'C一个不注意小事的人，永远不会成就大事。\r\n  理性是灵魂中最高贵的因素。\r\n  切忌浮夸，与其说得过分，不如说得不全。\r\n  谨慎比大胆要有力量得多。\r\n', 'D与其在死的时候握着一大把钱，还不如活时活得丰富多彩。\r\n  任何时候都要最真实地对待你自己，这比什么都重要。\r\n  使生活变成幻想，再把幻想化为现实。\r\n  和喜欢的人在一起做喜欢做的事是莫大的快乐。\r\n', 2, 0, '2021-11-23 11:13:16', 'chenjian', '2021-11-23 11:13:16', 'chenjian', 0);
INSERT INTO `tbl_character_question` VALUES (31, '你喜欢逻辑删除吗？', '121', '212', '2121', '212', 2, 0, '2021-11-30 16:22:28', 'wang', NULL, NULL, 1);

-- ----------------------------
-- Table structure for tbl_character_result
-- ----------------------------
DROP TABLE IF EXISTS `tbl_character_result`;
CREATE TABLE `tbl_character_result`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `tester_id` int(11) NULL DEFAULT NULL COMMENT '测试人员id',
  `question_id` int(11) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '测试题id',
  `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应题目提交结果',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 511 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_character_result
-- ----------------------------
INSERT INTO `tbl_character_result` VALUES (1, 14, 00000000001, 'A');
INSERT INTO `tbl_character_result` VALUES (2, 14, 00000000002, 'A');
INSERT INTO `tbl_character_result` VALUES (3, 14, 00000000003, 'A');
INSERT INTO `tbl_character_result` VALUES (4, 14, 00000000004, 'A');
INSERT INTO `tbl_character_result` VALUES (5, 14, 00000000005, 'A');
INSERT INTO `tbl_character_result` VALUES (6, 14, 00000000006, 'B');
INSERT INTO `tbl_character_result` VALUES (7, 14, 00000000007, 'B');
INSERT INTO `tbl_character_result` VALUES (8, 14, 00000000008, 'B');
INSERT INTO `tbl_character_result` VALUES (9, 14, 00000000009, 'B');
INSERT INTO `tbl_character_result` VALUES (10, 14, 00000000010, 'B');
INSERT INTO `tbl_character_result` VALUES (11, 14, 00000000011, 'B');
INSERT INTO `tbl_character_result` VALUES (12, 14, 00000000012, 'C');
INSERT INTO `tbl_character_result` VALUES (13, 14, 00000000013, 'C');
INSERT INTO `tbl_character_result` VALUES (14, 14, 00000000014, 'C');
INSERT INTO `tbl_character_result` VALUES (15, 14, 00000000015, 'C');
INSERT INTO `tbl_character_result` VALUES (16, 14, 00000000016, 'C');
INSERT INTO `tbl_character_result` VALUES (17, 14, 00000000017, 'C');
INSERT INTO `tbl_character_result` VALUES (18, 14, 00000000018, 'D');
INSERT INTO `tbl_character_result` VALUES (19, 14, 00000000019, 'D');
INSERT INTO `tbl_character_result` VALUES (20, 14, 00000000020, 'D');
INSERT INTO `tbl_character_result` VALUES (21, 14, 00000000021, 'D');
INSERT INTO `tbl_character_result` VALUES (22, 14, 00000000022, 'D');
INSERT INTO `tbl_character_result` VALUES (23, 14, 00000000023, 'D');
INSERT INTO `tbl_character_result` VALUES (24, 14, 00000000024, 'B');
INSERT INTO `tbl_character_result` VALUES (25, 14, 00000000025, 'B');
INSERT INTO `tbl_character_result` VALUES (26, 14, 00000000026, 'A');
INSERT INTO `tbl_character_result` VALUES (27, 14, 00000000027, 'A');
INSERT INTO `tbl_character_result` VALUES (28, 14, 00000000028, 'C');
INSERT INTO `tbl_character_result` VALUES (29, 14, 00000000029, 'C');
INSERT INTO `tbl_character_result` VALUES (30, 14, 00000000030, 'A');
INSERT INTO `tbl_character_result` VALUES (31, 21, 00000000001, 'A');
INSERT INTO `tbl_character_result` VALUES (32, 21, 00000000002, 'B');
INSERT INTO `tbl_character_result` VALUES (33, 21, 00000000003, 'A');
INSERT INTO `tbl_character_result` VALUES (34, 21, 00000000004, 'B');
INSERT INTO `tbl_character_result` VALUES (35, 21, 00000000005, 'C');
INSERT INTO `tbl_character_result` VALUES (36, 21, 00000000006, 'D');
INSERT INTO `tbl_character_result` VALUES (37, 21, 00000000007, 'B');
INSERT INTO `tbl_character_result` VALUES (38, 21, 00000000008, 'C');
INSERT INTO `tbl_character_result` VALUES (39, 21, 00000000009, 'B');
INSERT INTO `tbl_character_result` VALUES (40, 21, 00000000010, 'C');
INSERT INTO `tbl_character_result` VALUES (41, 21, 00000000011, 'B');
INSERT INTO `tbl_character_result` VALUES (42, 21, 00000000012, 'A');
INSERT INTO `tbl_character_result` VALUES (43, 21, 00000000013, 'B');
INSERT INTO `tbl_character_result` VALUES (44, 21, 00000000014, 'C');
INSERT INTO `tbl_character_result` VALUES (45, 21, 00000000015, 'B');
INSERT INTO `tbl_character_result` VALUES (46, 21, 00000000016, 'A');
INSERT INTO `tbl_character_result` VALUES (47, 21, 00000000017, 'B');
INSERT INTO `tbl_character_result` VALUES (48, 21, 00000000018, 'C');
INSERT INTO `tbl_character_result` VALUES (49, 21, 00000000019, 'B');
INSERT INTO `tbl_character_result` VALUES (50, 21, 00000000020, 'C');
INSERT INTO `tbl_character_result` VALUES (51, 21, 00000000021, 'B');
INSERT INTO `tbl_character_result` VALUES (52, 21, 00000000022, 'A');
INSERT INTO `tbl_character_result` VALUES (53, 21, 00000000023, 'C');
INSERT INTO `tbl_character_result` VALUES (54, 21, 00000000024, 'B');
INSERT INTO `tbl_character_result` VALUES (55, 21, 00000000025, 'A');
INSERT INTO `tbl_character_result` VALUES (56, 21, 00000000026, 'B');
INSERT INTO `tbl_character_result` VALUES (57, 21, 00000000027, 'D');
INSERT INTO `tbl_character_result` VALUES (58, 21, 00000000028, 'C');
INSERT INTO `tbl_character_result` VALUES (59, 21, 00000000029, 'B');
INSERT INTO `tbl_character_result` VALUES (60, 21, 00000000030, 'A');
INSERT INTO `tbl_character_result` VALUES (61, 25, 00000000001, 'B');
INSERT INTO `tbl_character_result` VALUES (62, 25, 00000000002, 'A');
INSERT INTO `tbl_character_result` VALUES (63, 25, 00000000003, 'B');
INSERT INTO `tbl_character_result` VALUES (64, 25, 00000000004, 'B');
INSERT INTO `tbl_character_result` VALUES (65, 25, 00000000005, 'C');
INSERT INTO `tbl_character_result` VALUES (66, 25, 00000000006, 'C');
INSERT INTO `tbl_character_result` VALUES (67, 25, 00000000007, 'C');
INSERT INTO `tbl_character_result` VALUES (68, 25, 00000000008, 'C');
INSERT INTO `tbl_character_result` VALUES (69, 25, 00000000009, 'C');
INSERT INTO `tbl_character_result` VALUES (70, 25, 00000000010, 'C');
INSERT INTO `tbl_character_result` VALUES (71, 25, 00000000011, 'D');
INSERT INTO `tbl_character_result` VALUES (72, 25, 00000000012, 'D');
INSERT INTO `tbl_character_result` VALUES (73, 25, 00000000013, 'D');
INSERT INTO `tbl_character_result` VALUES (74, 25, 00000000014, 'D');
INSERT INTO `tbl_character_result` VALUES (75, 25, 00000000015, 'D');
INSERT INTO `tbl_character_result` VALUES (76, 25, 00000000016, 'A');
INSERT INTO `tbl_character_result` VALUES (77, 25, 00000000017, 'A');
INSERT INTO `tbl_character_result` VALUES (78, 25, 00000000018, 'A');
INSERT INTO `tbl_character_result` VALUES (79, 25, 00000000019, 'A');
INSERT INTO `tbl_character_result` VALUES (80, 25, 00000000020, 'A');
INSERT INTO `tbl_character_result` VALUES (81, 25, 00000000021, 'A');
INSERT INTO `tbl_character_result` VALUES (82, 25, 00000000022, 'A');
INSERT INTO `tbl_character_result` VALUES (83, 25, 00000000023, 'B');
INSERT INTO `tbl_character_result` VALUES (84, 25, 00000000024, 'B');
INSERT INTO `tbl_character_result` VALUES (85, 25, 00000000025, 'C');
INSERT INTO `tbl_character_result` VALUES (86, 25, 00000000026, 'C');
INSERT INTO `tbl_character_result` VALUES (87, 25, 00000000027, 'B');
INSERT INTO `tbl_character_result` VALUES (88, 25, 00000000028, 'B');
INSERT INTO `tbl_character_result` VALUES (89, 25, 00000000029, 'A');
INSERT INTO `tbl_character_result` VALUES (90, 25, 00000000030, 'A');
INSERT INTO `tbl_character_result` VALUES (91, 26, 00000000001, 'A');
INSERT INTO `tbl_character_result` VALUES (92, 26, 00000000002, 'B');
INSERT INTO `tbl_character_result` VALUES (93, 26, 00000000003, 'A');
INSERT INTO `tbl_character_result` VALUES (94, 26, 00000000004, 'B');
INSERT INTO `tbl_character_result` VALUES (95, 26, 00000000005, 'C');
INSERT INTO `tbl_character_result` VALUES (96, 26, 00000000006, 'D');
INSERT INTO `tbl_character_result` VALUES (97, 26, 00000000007, 'C');
INSERT INTO `tbl_character_result` VALUES (98, 26, 00000000008, 'B');
INSERT INTO `tbl_character_result` VALUES (99, 26, 00000000009, 'A');
INSERT INTO `tbl_character_result` VALUES (100, 26, 00000000010, 'B');
INSERT INTO `tbl_character_result` VALUES (101, 26, 00000000011, 'C');
INSERT INTO `tbl_character_result` VALUES (102, 26, 00000000012, 'D');
INSERT INTO `tbl_character_result` VALUES (103, 26, 00000000013, 'C');
INSERT INTO `tbl_character_result` VALUES (104, 26, 00000000014, 'B');
INSERT INTO `tbl_character_result` VALUES (105, 26, 00000000015, 'C');
INSERT INTO `tbl_character_result` VALUES (106, 26, 00000000016, 'B');
INSERT INTO `tbl_character_result` VALUES (107, 26, 00000000017, 'B');
INSERT INTO `tbl_character_result` VALUES (108, 26, 00000000018, 'A');
INSERT INTO `tbl_character_result` VALUES (109, 26, 00000000019, 'B');
INSERT INTO `tbl_character_result` VALUES (110, 26, 00000000020, 'A');
INSERT INTO `tbl_character_result` VALUES (111, 26, 00000000021, 'B');
INSERT INTO `tbl_character_result` VALUES (112, 26, 00000000022, 'C');
INSERT INTO `tbl_character_result` VALUES (113, 26, 00000000023, 'D');
INSERT INTO `tbl_character_result` VALUES (114, 26, 00000000024, 'C');
INSERT INTO `tbl_character_result` VALUES (115, 26, 00000000025, 'B');
INSERT INTO `tbl_character_result` VALUES (116, 26, 00000000026, 'A');
INSERT INTO `tbl_character_result` VALUES (117, 26, 00000000027, 'B');
INSERT INTO `tbl_character_result` VALUES (118, 26, 00000000028, 'C');
INSERT INTO `tbl_character_result` VALUES (119, 26, 00000000029, 'B');
INSERT INTO `tbl_character_result` VALUES (120, 26, 00000000030, 'A');
INSERT INTO `tbl_character_result` VALUES (121, 27, 00000000001, 'A');
INSERT INTO `tbl_character_result` VALUES (122, 27, 00000000002, 'B');
INSERT INTO `tbl_character_result` VALUES (123, 27, 00000000003, 'C');
INSERT INTO `tbl_character_result` VALUES (124, 27, 00000000004, 'D');
INSERT INTO `tbl_character_result` VALUES (125, 27, 00000000005, 'B');
INSERT INTO `tbl_character_result` VALUES (126, 27, 00000000006, 'C');
INSERT INTO `tbl_character_result` VALUES (127, 27, 00000000007, 'B');
INSERT INTO `tbl_character_result` VALUES (128, 27, 00000000008, 'A');
INSERT INTO `tbl_character_result` VALUES (129, 27, 00000000009, 'B');
INSERT INTO `tbl_character_result` VALUES (130, 27, 00000000010, 'C');
INSERT INTO `tbl_character_result` VALUES (131, 27, 00000000011, 'D');
INSERT INTO `tbl_character_result` VALUES (132, 27, 00000000012, 'C');
INSERT INTO `tbl_character_result` VALUES (133, 27, 00000000013, 'B');
INSERT INTO `tbl_character_result` VALUES (134, 27, 00000000014, 'A');
INSERT INTO `tbl_character_result` VALUES (135, 27, 00000000015, 'B');
INSERT INTO `tbl_character_result` VALUES (136, 27, 00000000016, 'C');
INSERT INTO `tbl_character_result` VALUES (137, 27, 00000000017, 'D');
INSERT INTO `tbl_character_result` VALUES (138, 27, 00000000018, 'C');
INSERT INTO `tbl_character_result` VALUES (139, 27, 00000000019, 'B');
INSERT INTO `tbl_character_result` VALUES (140, 27, 00000000020, 'B');
INSERT INTO `tbl_character_result` VALUES (141, 27, 00000000021, 'B');
INSERT INTO `tbl_character_result` VALUES (142, 27, 00000000022, 'C');
INSERT INTO `tbl_character_result` VALUES (143, 27, 00000000023, 'D');
INSERT INTO `tbl_character_result` VALUES (144, 27, 00000000024, 'C');
INSERT INTO `tbl_character_result` VALUES (145, 27, 00000000025, 'B');
INSERT INTO `tbl_character_result` VALUES (146, 27, 00000000026, 'C');
INSERT INTO `tbl_character_result` VALUES (147, 27, 00000000027, 'D');
INSERT INTO `tbl_character_result` VALUES (148, 27, 00000000028, 'C');
INSERT INTO `tbl_character_result` VALUES (149, 27, 00000000029, 'C');
INSERT INTO `tbl_character_result` VALUES (150, 27, 00000000030, 'A');
INSERT INTO `tbl_character_result` VALUES (151, 28, 00000000001, 'A');
INSERT INTO `tbl_character_result` VALUES (152, 28, 00000000002, 'B');
INSERT INTO `tbl_character_result` VALUES (153, 28, 00000000003, 'C');
INSERT INTO `tbl_character_result` VALUES (154, 28, 00000000004, 'C');
INSERT INTO `tbl_character_result` VALUES (155, 28, 00000000005, 'D');
INSERT INTO `tbl_character_result` VALUES (156, 28, 00000000006, 'B');
INSERT INTO `tbl_character_result` VALUES (157, 28, 00000000007, 'B');
INSERT INTO `tbl_character_result` VALUES (158, 28, 00000000008, 'C');
INSERT INTO `tbl_character_result` VALUES (159, 28, 00000000009, 'D');
INSERT INTO `tbl_character_result` VALUES (160, 28, 00000000010, 'D');
INSERT INTO `tbl_character_result` VALUES (161, 28, 00000000011, 'D');
INSERT INTO `tbl_character_result` VALUES (162, 28, 00000000012, 'B');
INSERT INTO `tbl_character_result` VALUES (163, 28, 00000000013, 'A');
INSERT INTO `tbl_character_result` VALUES (164, 28, 00000000014, 'A');
INSERT INTO `tbl_character_result` VALUES (165, 28, 00000000015, 'B');
INSERT INTO `tbl_character_result` VALUES (166, 28, 00000000016, 'C');
INSERT INTO `tbl_character_result` VALUES (167, 28, 00000000017, 'C');
INSERT INTO `tbl_character_result` VALUES (168, 28, 00000000018, 'B');
INSERT INTO `tbl_character_result` VALUES (169, 28, 00000000019, 'B');
INSERT INTO `tbl_character_result` VALUES (170, 28, 00000000020, 'C');
INSERT INTO `tbl_character_result` VALUES (171, 28, 00000000021, 'C');
INSERT INTO `tbl_character_result` VALUES (172, 28, 00000000022, 'D');
INSERT INTO `tbl_character_result` VALUES (173, 28, 00000000023, 'D');
INSERT INTO `tbl_character_result` VALUES (174, 28, 00000000024, 'D');
INSERT INTO `tbl_character_result` VALUES (175, 28, 00000000025, 'A');
INSERT INTO `tbl_character_result` VALUES (176, 28, 00000000026, 'A');
INSERT INTO `tbl_character_result` VALUES (177, 28, 00000000027, 'A');
INSERT INTO `tbl_character_result` VALUES (178, 28, 00000000028, 'B');
INSERT INTO `tbl_character_result` VALUES (179, 28, 00000000029, 'B');
INSERT INTO `tbl_character_result` VALUES (180, 28, 00000000030, 'A');
INSERT INTO `tbl_character_result` VALUES (181, 29, 00000000001, 'A');
INSERT INTO `tbl_character_result` VALUES (182, 29, 00000000002, 'B');
INSERT INTO `tbl_character_result` VALUES (183, 29, 00000000003, 'B');
INSERT INTO `tbl_character_result` VALUES (184, 29, 00000000004, 'C');
INSERT INTO `tbl_character_result` VALUES (185, 29, 00000000005, 'C');
INSERT INTO `tbl_character_result` VALUES (186, 29, 00000000006, 'D');
INSERT INTO `tbl_character_result` VALUES (187, 29, 00000000007, 'D');
INSERT INTO `tbl_character_result` VALUES (188, 29, 00000000008, 'D');
INSERT INTO `tbl_character_result` VALUES (189, 29, 00000000009, 'C');
INSERT INTO `tbl_character_result` VALUES (190, 29, 00000000010, 'B');
INSERT INTO `tbl_character_result` VALUES (191, 29, 00000000011, 'B');
INSERT INTO `tbl_character_result` VALUES (192, 29, 00000000012, 'A');
INSERT INTO `tbl_character_result` VALUES (193, 29, 00000000013, 'B');
INSERT INTO `tbl_character_result` VALUES (194, 29, 00000000014, 'B');
INSERT INTO `tbl_character_result` VALUES (195, 29, 00000000015, 'C');
INSERT INTO `tbl_character_result` VALUES (196, 29, 00000000016, 'C');
INSERT INTO `tbl_character_result` VALUES (197, 29, 00000000017, 'B');
INSERT INTO `tbl_character_result` VALUES (198, 29, 00000000018, 'A');
INSERT INTO `tbl_character_result` VALUES (199, 29, 00000000019, 'B');
INSERT INTO `tbl_character_result` VALUES (200, 29, 00000000020, 'D');
INSERT INTO `tbl_character_result` VALUES (201, 29, 00000000021, 'C');
INSERT INTO `tbl_character_result` VALUES (202, 29, 00000000022, 'B');
INSERT INTO `tbl_character_result` VALUES (203, 29, 00000000023, 'A');
INSERT INTO `tbl_character_result` VALUES (204, 29, 00000000024, 'C');
INSERT INTO `tbl_character_result` VALUES (205, 29, 00000000025, 'C');
INSERT INTO `tbl_character_result` VALUES (206, 29, 00000000026, 'A');
INSERT INTO `tbl_character_result` VALUES (207, 29, 00000000027, 'B');
INSERT INTO `tbl_character_result` VALUES (208, 29, 00000000028, 'C');
INSERT INTO `tbl_character_result` VALUES (209, 29, 00000000029, 'B');
INSERT INTO `tbl_character_result` VALUES (210, 29, 00000000030, 'A');
INSERT INTO `tbl_character_result` VALUES (211, 30, 00000000001, 'A');
INSERT INTO `tbl_character_result` VALUES (212, 30, 00000000002, 'B');
INSERT INTO `tbl_character_result` VALUES (213, 30, 00000000003, 'C');
INSERT INTO `tbl_character_result` VALUES (214, 30, 00000000004, 'D');
INSERT INTO `tbl_character_result` VALUES (215, 30, 00000000005, 'D');
INSERT INTO `tbl_character_result` VALUES (216, 30, 00000000006, 'D');
INSERT INTO `tbl_character_result` VALUES (217, 30, 00000000007, 'C');
INSERT INTO `tbl_character_result` VALUES (218, 30, 00000000008, 'C');
INSERT INTO `tbl_character_result` VALUES (219, 30, 00000000009, 'B');
INSERT INTO `tbl_character_result` VALUES (220, 30, 00000000010, 'B');
INSERT INTO `tbl_character_result` VALUES (221, 30, 00000000011, 'B');
INSERT INTO `tbl_character_result` VALUES (222, 30, 00000000012, 'C');
INSERT INTO `tbl_character_result` VALUES (223, 30, 00000000013, 'C');
INSERT INTO `tbl_character_result` VALUES (224, 30, 00000000014, 'A');
INSERT INTO `tbl_character_result` VALUES (225, 30, 00000000015, 'A');
INSERT INTO `tbl_character_result` VALUES (226, 30, 00000000016, 'B');
INSERT INTO `tbl_character_result` VALUES (227, 30, 00000000017, 'B');
INSERT INTO `tbl_character_result` VALUES (228, 30, 00000000018, 'C');
INSERT INTO `tbl_character_result` VALUES (229, 30, 00000000019, 'D');
INSERT INTO `tbl_character_result` VALUES (230, 30, 00000000020, 'D');
INSERT INTO `tbl_character_result` VALUES (231, 30, 00000000021, 'C');
INSERT INTO `tbl_character_result` VALUES (232, 30, 00000000022, 'B');
INSERT INTO `tbl_character_result` VALUES (233, 30, 00000000023, 'A');
INSERT INTO `tbl_character_result` VALUES (234, 30, 00000000024, 'A');
INSERT INTO `tbl_character_result` VALUES (235, 30, 00000000025, 'B');
INSERT INTO `tbl_character_result` VALUES (236, 30, 00000000026, 'C');
INSERT INTO `tbl_character_result` VALUES (237, 30, 00000000027, 'C');
INSERT INTO `tbl_character_result` VALUES (238, 30, 00000000028, 'D');
INSERT INTO `tbl_character_result` VALUES (239, 30, 00000000029, 'D');
INSERT INTO `tbl_character_result` VALUES (240, 30, 00000000030, 'A');
INSERT INTO `tbl_character_result` VALUES (241, 31, 00000000001, 'C');
INSERT INTO `tbl_character_result` VALUES (242, 31, 00000000002, 'C');
INSERT INTO `tbl_character_result` VALUES (243, 31, 00000000003, 'B');
INSERT INTO `tbl_character_result` VALUES (244, 31, 00000000004, 'B');
INSERT INTO `tbl_character_result` VALUES (245, 31, 00000000005, 'B');
INSERT INTO `tbl_character_result` VALUES (246, 31, 00000000006, 'B');
INSERT INTO `tbl_character_result` VALUES (247, 31, 00000000007, 'C');
INSERT INTO `tbl_character_result` VALUES (248, 31, 00000000008, 'C');
INSERT INTO `tbl_character_result` VALUES (249, 31, 00000000009, 'D');
INSERT INTO `tbl_character_result` VALUES (250, 31, 00000000010, 'D');
INSERT INTO `tbl_character_result` VALUES (251, 31, 00000000011, 'C');
INSERT INTO `tbl_character_result` VALUES (252, 31, 00000000012, 'C');
INSERT INTO `tbl_character_result` VALUES (253, 31, 00000000013, 'B');
INSERT INTO `tbl_character_result` VALUES (254, 31, 00000000014, 'B');
INSERT INTO `tbl_character_result` VALUES (255, 31, 00000000015, 'A');
INSERT INTO `tbl_character_result` VALUES (256, 31, 00000000016, 'A');
INSERT INTO `tbl_character_result` VALUES (257, 31, 00000000017, 'B');
INSERT INTO `tbl_character_result` VALUES (258, 31, 00000000018, 'B');
INSERT INTO `tbl_character_result` VALUES (259, 31, 00000000019, 'C');
INSERT INTO `tbl_character_result` VALUES (260, 31, 00000000020, 'C');
INSERT INTO `tbl_character_result` VALUES (261, 31, 00000000021, 'D');
INSERT INTO `tbl_character_result` VALUES (262, 31, 00000000022, 'C');
INSERT INTO `tbl_character_result` VALUES (263, 31, 00000000023, 'C');
INSERT INTO `tbl_character_result` VALUES (264, 31, 00000000024, 'C');
INSERT INTO `tbl_character_result` VALUES (265, 31, 00000000025, 'A');
INSERT INTO `tbl_character_result` VALUES (266, 31, 00000000026, 'A');
INSERT INTO `tbl_character_result` VALUES (267, 31, 00000000027, 'A');
INSERT INTO `tbl_character_result` VALUES (268, 31, 00000000028, 'A');
INSERT INTO `tbl_character_result` VALUES (269, 31, 00000000029, 'A');
INSERT INTO `tbl_character_result` VALUES (270, 31, 00000000030, 'A');
INSERT INTO `tbl_character_result` VALUES (271, 32, 00000000001, 'A');
INSERT INTO `tbl_character_result` VALUES (272, 32, 00000000002, 'B');
INSERT INTO `tbl_character_result` VALUES (273, 32, 00000000003, 'C');
INSERT INTO `tbl_character_result` VALUES (274, 32, 00000000004, 'D');
INSERT INTO `tbl_character_result` VALUES (275, 32, 00000000005, 'C');
INSERT INTO `tbl_character_result` VALUES (276, 32, 00000000006, 'B');
INSERT INTO `tbl_character_result` VALUES (277, 32, 00000000007, 'A');
INSERT INTO `tbl_character_result` VALUES (278, 32, 00000000008, 'B');
INSERT INTO `tbl_character_result` VALUES (279, 32, 00000000009, 'C');
INSERT INTO `tbl_character_result` VALUES (280, 32, 00000000010, 'D');
INSERT INTO `tbl_character_result` VALUES (281, 32, 00000000011, 'C');
INSERT INTO `tbl_character_result` VALUES (282, 32, 00000000012, 'B');
INSERT INTO `tbl_character_result` VALUES (283, 32, 00000000013, 'A');
INSERT INTO `tbl_character_result` VALUES (284, 32, 00000000014, 'B');
INSERT INTO `tbl_character_result` VALUES (285, 32, 00000000015, 'C');
INSERT INTO `tbl_character_result` VALUES (286, 32, 00000000016, 'D');
INSERT INTO `tbl_character_result` VALUES (287, 32, 00000000017, 'C');
INSERT INTO `tbl_character_result` VALUES (288, 32, 00000000018, 'B');
INSERT INTO `tbl_character_result` VALUES (289, 32, 00000000019, 'A');
INSERT INTO `tbl_character_result` VALUES (290, 32, 00000000020, 'B');
INSERT INTO `tbl_character_result` VALUES (291, 32, 00000000021, 'C');
INSERT INTO `tbl_character_result` VALUES (292, 32, 00000000022, 'D');
INSERT INTO `tbl_character_result` VALUES (293, 32, 00000000023, 'C');
INSERT INTO `tbl_character_result` VALUES (294, 32, 00000000024, 'B');
INSERT INTO `tbl_character_result` VALUES (295, 32, 00000000025, 'A');
INSERT INTO `tbl_character_result` VALUES (296, 32, 00000000026, 'B');
INSERT INTO `tbl_character_result` VALUES (297, 32, 00000000027, 'C');
INSERT INTO `tbl_character_result` VALUES (298, 32, 00000000028, 'D');
INSERT INTO `tbl_character_result` VALUES (299, 32, 00000000029, 'C');
INSERT INTO `tbl_character_result` VALUES (300, 32, 00000000030, 'A');
INSERT INTO `tbl_character_result` VALUES (301, 33, 00000000001, 'A');
INSERT INTO `tbl_character_result` VALUES (302, 33, 00000000002, 'A');
INSERT INTO `tbl_character_result` VALUES (303, 33, 00000000003, 'B');
INSERT INTO `tbl_character_result` VALUES (304, 33, 00000000004, 'A');
INSERT INTO `tbl_character_result` VALUES (305, 33, 00000000005, 'A');
INSERT INTO `tbl_character_result` VALUES (306, 33, 00000000006, 'B');
INSERT INTO `tbl_character_result` VALUES (307, 33, 00000000007, 'B');
INSERT INTO `tbl_character_result` VALUES (308, 33, 00000000008, 'C');
INSERT INTO `tbl_character_result` VALUES (309, 33, 00000000009, 'C');
INSERT INTO `tbl_character_result` VALUES (310, 33, 00000000010, 'C');
INSERT INTO `tbl_character_result` VALUES (311, 33, 00000000011, 'C');
INSERT INTO `tbl_character_result` VALUES (312, 33, 00000000012, 'C');
INSERT INTO `tbl_character_result` VALUES (313, 33, 00000000013, 'C');
INSERT INTO `tbl_character_result` VALUES (314, 33, 00000000014, 'C');
INSERT INTO `tbl_character_result` VALUES (315, 33, 00000000015, 'C');
INSERT INTO `tbl_character_result` VALUES (316, 33, 00000000016, 'C');
INSERT INTO `tbl_character_result` VALUES (317, 33, 00000000017, 'D');
INSERT INTO `tbl_character_result` VALUES (318, 33, 00000000018, 'D');
INSERT INTO `tbl_character_result` VALUES (319, 33, 00000000019, 'D');
INSERT INTO `tbl_character_result` VALUES (320, 33, 00000000020, 'D');
INSERT INTO `tbl_character_result` VALUES (321, 33, 00000000021, 'D');
INSERT INTO `tbl_character_result` VALUES (322, 33, 00000000022, 'D');
INSERT INTO `tbl_character_result` VALUES (323, 33, 00000000023, 'D');
INSERT INTO `tbl_character_result` VALUES (324, 33, 00000000024, 'D');
INSERT INTO `tbl_character_result` VALUES (325, 33, 00000000025, 'B');
INSERT INTO `tbl_character_result` VALUES (326, 33, 00000000026, 'B');
INSERT INTO `tbl_character_result` VALUES (327, 33, 00000000027, 'B');
INSERT INTO `tbl_character_result` VALUES (328, 33, 00000000028, 'B');
INSERT INTO `tbl_character_result` VALUES (329, 33, 00000000029, 'A');
INSERT INTO `tbl_character_result` VALUES (330, 33, 00000000030, 'A');
INSERT INTO `tbl_character_result` VALUES (331, 34, 00000000001, 'D');
INSERT INTO `tbl_character_result` VALUES (332, 34, 00000000002, 'B');
INSERT INTO `tbl_character_result` VALUES (333, 34, 00000000003, 'B');
INSERT INTO `tbl_character_result` VALUES (334, 34, 00000000004, 'B');
INSERT INTO `tbl_character_result` VALUES (335, 34, 00000000005, 'B');
INSERT INTO `tbl_character_result` VALUES (336, 34, 00000000006, 'B');
INSERT INTO `tbl_character_result` VALUES (337, 34, 00000000007, 'B');
INSERT INTO `tbl_character_result` VALUES (338, 34, 00000000008, 'B');
INSERT INTO `tbl_character_result` VALUES (339, 34, 00000000009, 'C');
INSERT INTO `tbl_character_result` VALUES (340, 34, 00000000010, 'C');
INSERT INTO `tbl_character_result` VALUES (341, 34, 00000000011, 'C');
INSERT INTO `tbl_character_result` VALUES (342, 34, 00000000012, 'D');
INSERT INTO `tbl_character_result` VALUES (343, 34, 00000000013, 'D');
INSERT INTO `tbl_character_result` VALUES (344, 34, 00000000014, 'D');
INSERT INTO `tbl_character_result` VALUES (345, 34, 00000000015, 'D');
INSERT INTO `tbl_character_result` VALUES (346, 34, 00000000016, 'D');
INSERT INTO `tbl_character_result` VALUES (347, 34, 00000000017, 'A');
INSERT INTO `tbl_character_result` VALUES (348, 34, 00000000018, 'A');
INSERT INTO `tbl_character_result` VALUES (349, 34, 00000000019, 'A');
INSERT INTO `tbl_character_result` VALUES (350, 34, 00000000020, 'A');
INSERT INTO `tbl_character_result` VALUES (351, 34, 00000000021, 'A');
INSERT INTO `tbl_character_result` VALUES (352, 34, 00000000022, 'A');
INSERT INTO `tbl_character_result` VALUES (353, 34, 00000000023, 'A');
INSERT INTO `tbl_character_result` VALUES (354, 34, 00000000024, 'A');
INSERT INTO `tbl_character_result` VALUES (355, 34, 00000000025, 'A');
INSERT INTO `tbl_character_result` VALUES (356, 34, 00000000026, 'B');
INSERT INTO `tbl_character_result` VALUES (357, 34, 00000000027, 'B');
INSERT INTO `tbl_character_result` VALUES (358, 34, 00000000028, 'B');
INSERT INTO `tbl_character_result` VALUES (359, 34, 00000000029, 'B');
INSERT INTO `tbl_character_result` VALUES (360, 34, 00000000030, 'A');
INSERT INTO `tbl_character_result` VALUES (361, 35, 00000000001, 'B');
INSERT INTO `tbl_character_result` VALUES (362, 35, 00000000002, 'B');
INSERT INTO `tbl_character_result` VALUES (363, 35, 00000000003, 'B');
INSERT INTO `tbl_character_result` VALUES (364, 35, 00000000004, 'C');
INSERT INTO `tbl_character_result` VALUES (365, 35, 00000000005, 'C');
INSERT INTO `tbl_character_result` VALUES (366, 35, 00000000006, 'C');
INSERT INTO `tbl_character_result` VALUES (367, 35, 00000000007, 'C');
INSERT INTO `tbl_character_result` VALUES (368, 35, 00000000008, 'C');
INSERT INTO `tbl_character_result` VALUES (369, 35, 00000000009, 'D');
INSERT INTO `tbl_character_result` VALUES (370, 35, 00000000010, 'D');
INSERT INTO `tbl_character_result` VALUES (371, 35, 00000000011, 'D');
INSERT INTO `tbl_character_result` VALUES (372, 35, 00000000012, 'D');
INSERT INTO `tbl_character_result` VALUES (373, 35, 00000000013, 'D');
INSERT INTO `tbl_character_result` VALUES (374, 35, 00000000014, 'D');
INSERT INTO `tbl_character_result` VALUES (375, 35, 00000000015, 'D');
INSERT INTO `tbl_character_result` VALUES (376, 35, 00000000016, 'B');
INSERT INTO `tbl_character_result` VALUES (377, 35, 00000000017, 'B');
INSERT INTO `tbl_character_result` VALUES (378, 35, 00000000018, 'B');
INSERT INTO `tbl_character_result` VALUES (379, 35, 00000000019, 'B');
INSERT INTO `tbl_character_result` VALUES (380, 35, 00000000020, 'A');
INSERT INTO `tbl_character_result` VALUES (381, 35, 00000000021, 'A');
INSERT INTO `tbl_character_result` VALUES (382, 35, 00000000022, 'B');
INSERT INTO `tbl_character_result` VALUES (383, 35, 00000000023, 'B');
INSERT INTO `tbl_character_result` VALUES (384, 35, 00000000024, 'B');
INSERT INTO `tbl_character_result` VALUES (385, 35, 00000000025, 'B');
INSERT INTO `tbl_character_result` VALUES (386, 35, 00000000026, 'B');
INSERT INTO `tbl_character_result` VALUES (387, 35, 00000000027, 'B');
INSERT INTO `tbl_character_result` VALUES (388, 35, 00000000028, 'B');
INSERT INTO `tbl_character_result` VALUES (389, 35, 00000000029, 'B');
INSERT INTO `tbl_character_result` VALUES (390, 35, 00000000030, 'A');
INSERT INTO `tbl_character_result` VALUES (391, 36, 00000000001, 'D');
INSERT INTO `tbl_character_result` VALUES (392, 36, 00000000002, 'D');
INSERT INTO `tbl_character_result` VALUES (393, 36, 00000000003, 'D');
INSERT INTO `tbl_character_result` VALUES (394, 36, 00000000004, 'D');
INSERT INTO `tbl_character_result` VALUES (395, 36, 00000000005, 'D');
INSERT INTO `tbl_character_result` VALUES (396, 36, 00000000006, 'D');
INSERT INTO `tbl_character_result` VALUES (397, 36, 00000000007, 'D');
INSERT INTO `tbl_character_result` VALUES (398, 36, 00000000008, 'D');
INSERT INTO `tbl_character_result` VALUES (399, 36, 00000000009, 'D');
INSERT INTO `tbl_character_result` VALUES (400, 36, 00000000010, 'D');
INSERT INTO `tbl_character_result` VALUES (401, 36, 00000000011, 'D');
INSERT INTO `tbl_character_result` VALUES (402, 36, 00000000012, 'C');
INSERT INTO `tbl_character_result` VALUES (403, 36, 00000000013, 'C');
INSERT INTO `tbl_character_result` VALUES (404, 36, 00000000014, 'C');
INSERT INTO `tbl_character_result` VALUES (405, 36, 00000000015, 'C');
INSERT INTO `tbl_character_result` VALUES (406, 36, 00000000016, 'C');
INSERT INTO `tbl_character_result` VALUES (407, 36, 00000000017, 'C');
INSERT INTO `tbl_character_result` VALUES (408, 36, 00000000018, 'B');
INSERT INTO `tbl_character_result` VALUES (409, 36, 00000000019, 'B');
INSERT INTO `tbl_character_result` VALUES (410, 36, 00000000020, 'B');
INSERT INTO `tbl_character_result` VALUES (411, 36, 00000000021, 'B');
INSERT INTO `tbl_character_result` VALUES (412, 36, 00000000022, 'A');
INSERT INTO `tbl_character_result` VALUES (413, 36, 00000000023, 'A');
INSERT INTO `tbl_character_result` VALUES (414, 36, 00000000024, 'B');
INSERT INTO `tbl_character_result` VALUES (415, 36, 00000000025, 'B');
INSERT INTO `tbl_character_result` VALUES (416, 36, 00000000026, 'C');
INSERT INTO `tbl_character_result` VALUES (417, 36, 00000000027, 'C');
INSERT INTO `tbl_character_result` VALUES (418, 36, 00000000028, 'C');
INSERT INTO `tbl_character_result` VALUES (419, 36, 00000000029, 'D');
INSERT INTO `tbl_character_result` VALUES (420, 36, 00000000030, 'A');
INSERT INTO `tbl_character_result` VALUES (421, 37, 00000000001, 'A');
INSERT INTO `tbl_character_result` VALUES (422, 37, 00000000002, 'B');
INSERT INTO `tbl_character_result` VALUES (423, 37, 00000000003, 'C');
INSERT INTO `tbl_character_result` VALUES (424, 37, 00000000004, 'C');
INSERT INTO `tbl_character_result` VALUES (425, 37, 00000000005, 'C');
INSERT INTO `tbl_character_result` VALUES (426, 37, 00000000006, 'D');
INSERT INTO `tbl_character_result` VALUES (427, 37, 00000000007, 'D');
INSERT INTO `tbl_character_result` VALUES (428, 37, 00000000008, 'D');
INSERT INTO `tbl_character_result` VALUES (429, 37, 00000000009, 'D');
INSERT INTO `tbl_character_result` VALUES (430, 37, 00000000010, 'B');
INSERT INTO `tbl_character_result` VALUES (431, 37, 00000000011, 'B');
INSERT INTO `tbl_character_result` VALUES (432, 37, 00000000012, 'B');
INSERT INTO `tbl_character_result` VALUES (433, 37, 00000000013, 'A');
INSERT INTO `tbl_character_result` VALUES (434, 37, 00000000014, 'A');
INSERT INTO `tbl_character_result` VALUES (435, 37, 00000000015, 'A');
INSERT INTO `tbl_character_result` VALUES (436, 37, 00000000016, 'A');
INSERT INTO `tbl_character_result` VALUES (437, 37, 00000000017, 'A');
INSERT INTO `tbl_character_result` VALUES (438, 37, 00000000018, 'A');
INSERT INTO `tbl_character_result` VALUES (439, 37, 00000000019, 'C');
INSERT INTO `tbl_character_result` VALUES (440, 37, 00000000020, 'C');
INSERT INTO `tbl_character_result` VALUES (441, 37, 00000000021, 'A');
INSERT INTO `tbl_character_result` VALUES (442, 37, 00000000022, 'B');
INSERT INTO `tbl_character_result` VALUES (443, 37, 00000000023, 'D');
INSERT INTO `tbl_character_result` VALUES (444, 37, 00000000024, 'C');
INSERT INTO `tbl_character_result` VALUES (445, 37, 00000000025, 'B');
INSERT INTO `tbl_character_result` VALUES (446, 37, 00000000026, 'C');
INSERT INTO `tbl_character_result` VALUES (447, 37, 00000000027, 'D');
INSERT INTO `tbl_character_result` VALUES (448, 37, 00000000028, 'A');
INSERT INTO `tbl_character_result` VALUES (449, 37, 00000000029, 'B');
INSERT INTO `tbl_character_result` VALUES (450, 37, 00000000030, 'A');
INSERT INTO `tbl_character_result` VALUES (451, 38, 00000000001, 'A');
INSERT INTO `tbl_character_result` VALUES (452, 38, 00000000002, 'B');
INSERT INTO `tbl_character_result` VALUES (453, 38, 00000000003, 'B');
INSERT INTO `tbl_character_result` VALUES (454, 38, 00000000004, 'D');
INSERT INTO `tbl_character_result` VALUES (455, 38, 00000000005, 'C');
INSERT INTO `tbl_character_result` VALUES (456, 38, 00000000006, 'A');
INSERT INTO `tbl_character_result` VALUES (457, 38, 00000000007, 'C');
INSERT INTO `tbl_character_result` VALUES (458, 38, 00000000008, 'D');
INSERT INTO `tbl_character_result` VALUES (459, 38, 00000000009, 'C');
INSERT INTO `tbl_character_result` VALUES (460, 38, 00000000010, 'B');
INSERT INTO `tbl_character_result` VALUES (461, 38, 00000000011, 'A');
INSERT INTO `tbl_character_result` VALUES (462, 38, 00000000012, 'B');
INSERT INTO `tbl_character_result` VALUES (463, 38, 00000000013, 'C');
INSERT INTO `tbl_character_result` VALUES (464, 38, 00000000014, 'D');
INSERT INTO `tbl_character_result` VALUES (465, 38, 00000000015, 'C');
INSERT INTO `tbl_character_result` VALUES (466, 38, 00000000016, 'B');
INSERT INTO `tbl_character_result` VALUES (467, 38, 00000000017, 'A');
INSERT INTO `tbl_character_result` VALUES (468, 38, 00000000018, 'B');
INSERT INTO `tbl_character_result` VALUES (469, 38, 00000000019, 'C');
INSERT INTO `tbl_character_result` VALUES (470, 38, 00000000020, 'C');
INSERT INTO `tbl_character_result` VALUES (471, 38, 00000000021, 'D');
INSERT INTO `tbl_character_result` VALUES (472, 38, 00000000022, 'D');
INSERT INTO `tbl_character_result` VALUES (473, 38, 00000000023, 'B');
INSERT INTO `tbl_character_result` VALUES (474, 38, 00000000024, 'B');
INSERT INTO `tbl_character_result` VALUES (475, 38, 00000000025, 'A');
INSERT INTO `tbl_character_result` VALUES (476, 38, 00000000026, 'C');
INSERT INTO `tbl_character_result` VALUES (477, 38, 00000000027, 'C');
INSERT INTO `tbl_character_result` VALUES (478, 38, 00000000028, 'B');
INSERT INTO `tbl_character_result` VALUES (479, 38, 00000000029, 'C');
INSERT INTO `tbl_character_result` VALUES (480, 38, 00000000030, 'A');
INSERT INTO `tbl_character_result` VALUES (481, 39, 00000000001, 'A');
INSERT INTO `tbl_character_result` VALUES (482, 39, 00000000002, 'B');
INSERT INTO `tbl_character_result` VALUES (483, 39, 00000000003, 'C');
INSERT INTO `tbl_character_result` VALUES (484, 39, 00000000004, 'C');
INSERT INTO `tbl_character_result` VALUES (485, 39, 00000000005, 'B');
INSERT INTO `tbl_character_result` VALUES (486, 39, 00000000006, 'B');
INSERT INTO `tbl_character_result` VALUES (487, 39, 00000000007, 'B');
INSERT INTO `tbl_character_result` VALUES (488, 39, 00000000008, 'B');
INSERT INTO `tbl_character_result` VALUES (489, 39, 00000000009, 'B');
INSERT INTO `tbl_character_result` VALUES (490, 39, 00000000010, 'B');
INSERT INTO `tbl_character_result` VALUES (491, 39, 00000000011, 'D');
INSERT INTO `tbl_character_result` VALUES (492, 39, 00000000012, 'D');
INSERT INTO `tbl_character_result` VALUES (493, 39, 00000000013, 'D');
INSERT INTO `tbl_character_result` VALUES (494, 39, 00000000014, 'D');
INSERT INTO `tbl_character_result` VALUES (495, 39, 00000000015, 'D');
INSERT INTO `tbl_character_result` VALUES (496, 39, 00000000016, 'D');
INSERT INTO `tbl_character_result` VALUES (497, 39, 00000000017, 'B');
INSERT INTO `tbl_character_result` VALUES (498, 39, 00000000018, 'B');
INSERT INTO `tbl_character_result` VALUES (499, 39, 00000000019, 'B');
INSERT INTO `tbl_character_result` VALUES (500, 39, 00000000020, 'B');
INSERT INTO `tbl_character_result` VALUES (501, 39, 00000000021, 'B');
INSERT INTO `tbl_character_result` VALUES (502, 39, 00000000022, 'B');
INSERT INTO `tbl_character_result` VALUES (503, 39, 00000000023, 'A');
INSERT INTO `tbl_character_result` VALUES (504, 39, 00000000024, 'A');
INSERT INTO `tbl_character_result` VALUES (505, 39, 00000000025, 'B');
INSERT INTO `tbl_character_result` VALUES (506, 39, 00000000026, 'C');
INSERT INTO `tbl_character_result` VALUES (507, 39, 00000000027, 'D');
INSERT INTO `tbl_character_result` VALUES (508, 39, 00000000028, 'C');
INSERT INTO `tbl_character_result` VALUES (509, 39, 00000000029, 'B');
INSERT INTO `tbl_character_result` VALUES (510, 39, 00000000030, 'A');

-- ----------------------------
-- Table structure for tbl_character_tester
-- ----------------------------
DROP TABLE IF EXISTS `tbl_character_tester`;
CREATE TABLE `tbl_character_tester`  (
  `tester_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `phonenum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号应该时唯一的',
  `tester_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '测试人姓名',
  `test_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '测试时间',
  PRIMARY KEY (`tester_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_character_tester
-- ----------------------------
INSERT INTO `tbl_character_tester` VALUES (14, '15093132818', '王龙飞', '2021-10-02 15:01:04');
INSERT INTO `tbl_character_tester` VALUES (21, '150931328190', '王昊', '2021-10-09 09:20:30');
INSERT INTO `tbl_character_tester` VALUES (25, '15093132868', '王凯', '2021-10-09 09:36:25');
INSERT INTO `tbl_character_tester` VALUES (26, '15093198972', '韩晓航', '2021-11-09 09:43:45');
INSERT INTO `tbl_character_tester` VALUES (27, '15138997712', '庞家铭', '2021-12-09 10:17:27');
INSERT INTO `tbl_character_tester` VALUES (28, '13315683838', '王刚', '2021-12-09 09:50:17');
INSERT INTO `tbl_character_tester` VALUES (29, '14121312321', '罗翔', '2021-12-09 09:50:50');
INSERT INTO `tbl_character_tester` VALUES (30, '15821123532', '王逸', '2021-12-09 09:51:42');
INSERT INTO `tbl_character_tester` VALUES (31, '182984284234', '董佳宁', '2021-12-09 09:52:09');
INSERT INTO `tbl_character_tester` VALUES (32, '15093132816', '大阳', '2021-12-09 10:09:02');
INSERT INTO `tbl_character_tester` VALUES (33, '15048912442', '华农', '2021-12-09 10:48:22');
INSERT INTO `tbl_character_tester` VALUES (34, '150932131321', '王潇', '2021-12-09 10:49:42');
INSERT INTO `tbl_character_tester` VALUES (35, '13827831231321', '宋义进', '2021-12-09 10:51:00');
INSERT INTO `tbl_character_tester` VALUES (36, '1358289831', '喻文波', '2021-12-09 10:51:45');
INSERT INTO `tbl_character_tester` VALUES (37, '18538062907', '陈老师', '2021-12-09 11:22:48');
INSERT INTO `tbl_character_tester` VALUES (38, '15039480875', '韩妞妞', '2021-12-09 22:53:26');
INSERT INTO `tbl_character_tester` VALUES (39, '15093132888', '王龙飞', '2021-12-10 14:42:11');

-- ----------------------------
-- Table structure for tbl_dept
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dept`;
CREATE TABLE `tbl_dept`  (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `dept_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `order_num` int(11) NULL DEFAULT 0 COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 115 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_dept
-- ----------------------------
INSERT INTO `tbl_dept` VALUES (101, '研发部门', 1, '0', '0', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00');
INSERT INTO `tbl_dept` VALUES (102, '市场部门', 2, '0', '0', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00');
INSERT INTO `tbl_dept` VALUES (103, '测试部门', 3, '0', '0', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2020-12-24 10:27:48');
INSERT INTO `tbl_dept` VALUES (104, '财务部门', 4, '0', '0', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00');
INSERT INTO `tbl_dept` VALUES (105, '运维部门', 5, '0', '0', 'Enzo', '2018-03-16 11:33:00', '陈建', '2021-12-07 15:18:33');
INSERT INTO `tbl_dept` VALUES (114, '人力资源部门', 2, '1', '0', '陈建', '2021-12-07 09:24:22', '陈建', '2021-12-07 10:39:49');

-- ----------------------------
-- Table structure for tbl_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dictionary`;
CREATE TABLE `tbl_dictionary`  (
  `dictionary_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL COMMENT '字典类型,关联字典类型表',
  `dictionary_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典名,展示时使用，保存的时候使用主键值',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` date NULL DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dictionary_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_dictionary
-- ----------------------------
INSERT INTO `tbl_dictionary` VALUES (1, 1, '1.化学制剂、肥料', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_dictionary` VALUES (2, 1, '2.颜料油漆、染料、防腐制品', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for tbl_dictionary_type
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dictionary_type`;
CREATE TABLE `tbl_dictionary_type`  (
  `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型ID，自增',
  `type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型名称，非空，唯一',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_dictionary_type
-- ----------------------------
INSERT INTO `tbl_dictionary_type` VALUES (1, '商标分类', 'Enzo', '2020-12-23 11:22:36', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for tbl_log
-- ----------------------------
DROP TABLE IF EXISTS `tbl_log`;
CREATE TABLE `tbl_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `login_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录名',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `class_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类名',
  `method_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '方法名',
  `params` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2380 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_log
-- ----------------------------
INSERT INTO `tbl_log` VALUES (1, NULL, NULL, '0:0:0:0:0:0:0:1', 'com.example.controller.PageController', 'toMlogin()', '[]', '2021-12-08 10:39:45');
INSERT INTO `tbl_log` VALUES (2, NULL, NULL, '0:0:0:0:0:0:0:1', 'com.example.controller.UserController', 'managerLogin(User,HttpSession)', '[User(userId=null, deptId=null, loginName=chenjian, userName=null, email=null, phonenumber=null, sex=null, avatar=null, password=123456, salt=null, status=null, flag=null, createBy=null, createTime=null, updateBy=null, updateTime=null, remark=null), org.apache.catalina.session.StandardSessionFacade@71f13c5e]', '2021-12-08 10:39:47');

-- ----------------------------
-- Table structure for tbl_menu
-- ----------------------------
DROP TABLE IF EXISTS `tbl_menu`;
CREATE TABLE `tbl_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int(11) NULL DEFAULT 0 COMMENT '显示顺序',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#' COMMENT '请求地址',
  `menu_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1032 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_menu
-- ----------------------------
INSERT INTO `tbl_menu` VALUES (1, '业务管理', 0, 2, '#', 'M', '0', '', 'layui-icon layui-icon-user', 'Enzo', '2018-03-16 11:33:00', '陈建', '2021-12-07 15:17:48', '活动管理目录');
INSERT INTO `tbl_menu` VALUES (3, '系统管理', 0, 1, '#', 'M', '0', '', 'layui-icon layui-icon-app', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '系统管理目录');
INSERT INTO `tbl_menu` VALUES (5, '日志监控', 0, 6, '#', 'M', '0', '', 'layui-icon layui-icon-log', '', '2021-01-21 17:46:05', NULL, NULL, '日志监控');
INSERT INTO `tbl_menu` VALUES (100, '用户管理', 3, 1, '/manager/toUser', 'C', '0', 'system:user:view', '#', 'Enzo', '2018-03-16 11:33:00', '陈建', '2021-12-08 11:01:39', '用户管理菜单');
INSERT INTO `tbl_menu` VALUES (101, '角色管理', 3, 2, '/manager/toRole', 'C', '0', 'system:role:view', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '角色管理菜单');
INSERT INTO `tbl_menu` VALUES (102, '菜单管理', 3, 3, '/manager/toMenu', 'C', '0', 'system:menu:view', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '菜单管理菜单');
INSERT INTO `tbl_menu` VALUES (103, '部门管理', 3, 4, '/manager/toDept', 'C', '0', 'system:dept:view', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '部门管理菜单');
INSERT INTO `tbl_menu` VALUES (109, '试题管理', 1, 3, '/manager/toquestionManager', 'C', '0', 'monitor:online:view', '#', 'Enzo', '2018-03-16 11:33:00', '陈建', '2021-12-09 09:55:07', '在线用户测试的题目');
INSERT INTO `tbl_menu` VALUES (111, '测试结果管理', 1, 2, '/manager/toTester', 'C', '0', 'monitor:data:view', '#', 'Enzo', '2018-03-16 11:33:00', '陈建', '2021-12-07 11:29:10', '数据监控菜单');
INSERT INTO `tbl_menu` VALUES (1000, '用户查询', 100, 1, '#', 'F', '0', 'system:user:list', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1001, '用户新增', 100, 2, '#', 'F', '0', 'system:user:add', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1002, '用户修改', 100, 3, '#', 'F', '0', 'system:user:edit', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1003, '用户删除', 100, 4, '#', 'F', '0', 'system:user:remove', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1004, '用户导出', 100, 5, '#', 'F', '0', 'system:user:export', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1005, '重置密码', 100, 6, '#', 'F', '0', 'system:user:resetPwd', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1006, '角色查询', 101, 1, '#', 'F', '0', 'system:role:list', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1007, '角色新增', 101, 2, '#', 'F', '0', 'system:role:add', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1008, '角色修改', 101, 3, '#', 'F', '0', 'system:role:edit', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1009, '角色删除', 101, 4, '#', 'F', '0', 'system:role:remove', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1010, '角色导出', 101, 5, '#', 'F', '0', 'system:role:export', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1011, '菜单查询', 102, 1, '#', 'F', '0', 'system:menu:list', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1012, '菜单新增', 102, 2, '#', 'F', '0', 'system:menu:add', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1013, '菜单修改', 102, 3, '#', 'F', '0', 'system:menu:edit', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1014, '菜单删除', 102, 4, '#', 'F', '0', 'system:menu:remove', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1015, '部门查询', 103, 1, '#', 'F', '0', 'system:dept:list', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1016, '部门新增', 103, 2, '#', 'F', '0', 'system:dept:add', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1017, '部门修改', 103, 3, '#', 'F', '0', 'system:dept:edit', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1018, '部门删除', 103, 4, '#', 'F', '0', 'system:dept:remove', '#', 'Enzo', '2018-03-16 11:33:00', 'Enzo', '2018-03-16 11:33:00', '');
INSERT INTO `tbl_menu` VALUES (1025, '操作日志', 5, 1, '/manager/toLog', 'C', '0', '', '#', 'Enzo', '2021-01-21 17:48:22', '陈建', '2021-12-08 10:35:22', '登陆日志');
INSERT INTO `tbl_menu` VALUES (1029, '测试结果大屏展示', 1, 1, '/manager/toIndex', 'C', '0', '', '#', '陈建', '2021-12-09 09:16:19', '陈建', '2021-12-09 09:24:21', '测试结果大屏展示');
INSERT INTO `tbl_menu` VALUES (1030, '增加问题', 109, 3, '', 'F', '0', 'add', '#', '陈建', '2021-12-09 10:57:12', '', NULL, '增加问题');
INSERT INTO `tbl_menu` VALUES (1031, '删除问题', 109, 4, '', 'F', '0', 'delete', '#', '陈建', '2021-12-09 10:58:00', '', NULL, '删除问题');

-- ----------------------------
-- Table structure for tbl_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role`;
CREATE TABLE `tbl_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(11) NOT NULL COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_role
-- ----------------------------
INSERT INTO `tbl_role` VALUES (1, '管理员', 'admin', 1, '0', '0', 'Enzo', '2018-03-16 11:33:00', '王龙飞', '2021-12-10 14:49:08', '管理员');
INSERT INTO `tbl_role` VALUES (2, '普通角色', 'common', 2, '0', '0', 'Enzo', '2018-03-16 11:33:00', '王龙飞', '2021-12-10 10:19:28', '普通角色');
INSERT INTO `tbl_role` VALUES (3, '测试', 'test', 3, '0', '0', '陈建', '2021-12-09 11:29:13', '', NULL, ' 测试');
INSERT INTO `tbl_role` VALUES (4, '测试1', 'test1', 4, '0', '1', '陈建', '2021-12-10 10:15:23', '', NULL, '111');

-- ----------------------------
-- Table structure for tbl_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role_menu`;
CREATE TABLE `tbl_role_menu`  (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_role_menu
-- ----------------------------
INSERT INTO `tbl_role_menu` VALUES (1, 1);
INSERT INTO `tbl_role_menu` VALUES (1, 3);
INSERT INTO `tbl_role_menu` VALUES (1, 5);
INSERT INTO `tbl_role_menu` VALUES (1, 100);
INSERT INTO `tbl_role_menu` VALUES (1, 101);
INSERT INTO `tbl_role_menu` VALUES (1, 102);
INSERT INTO `tbl_role_menu` VALUES (1, 103);
INSERT INTO `tbl_role_menu` VALUES (1, 109);
INSERT INTO `tbl_role_menu` VALUES (1, 111);
INSERT INTO `tbl_role_menu` VALUES (1, 1000);
INSERT INTO `tbl_role_menu` VALUES (1, 1001);
INSERT INTO `tbl_role_menu` VALUES (1, 1002);
INSERT INTO `tbl_role_menu` VALUES (1, 1003);
INSERT INTO `tbl_role_menu` VALUES (1, 1004);
INSERT INTO `tbl_role_menu` VALUES (1, 1005);
INSERT INTO `tbl_role_menu` VALUES (1, 1006);
INSERT INTO `tbl_role_menu` VALUES (1, 1007);
INSERT INTO `tbl_role_menu` VALUES (1, 1008);
INSERT INTO `tbl_role_menu` VALUES (1, 1009);
INSERT INTO `tbl_role_menu` VALUES (1, 1010);
INSERT INTO `tbl_role_menu` VALUES (1, 1011);
INSERT INTO `tbl_role_menu` VALUES (1, 1012);
INSERT INTO `tbl_role_menu` VALUES (1, 1013);
INSERT INTO `tbl_role_menu` VALUES (1, 1014);
INSERT INTO `tbl_role_menu` VALUES (1, 1015);
INSERT INTO `tbl_role_menu` VALUES (1, 1016);
INSERT INTO `tbl_role_menu` VALUES (1, 1017);
INSERT INTO `tbl_role_menu` VALUES (1, 1018);
INSERT INTO `tbl_role_menu` VALUES (1, 1025);
INSERT INTO `tbl_role_menu` VALUES (1, 1029);
INSERT INTO `tbl_role_menu` VALUES (1, 1030);
INSERT INTO `tbl_role_menu` VALUES (1, 1031);
INSERT INTO `tbl_role_menu` VALUES (2, 1);
INSERT INTO `tbl_role_menu` VALUES (2, 109);
INSERT INTO `tbl_role_menu` VALUES (2, 111);
INSERT INTO `tbl_role_menu` VALUES (2, 1029);
INSERT INTO `tbl_role_menu` VALUES (2, 1030);
INSERT INTO `tbl_role_menu` VALUES (2, 1031);
INSERT INTO `tbl_role_menu` VALUES (3, 1);
INSERT INTO `tbl_role_menu` VALUES (3, 3);
INSERT INTO `tbl_role_menu` VALUES (3, 100);
INSERT INTO `tbl_role_menu` VALUES (3, 101);
INSERT INTO `tbl_role_menu` VALUES (3, 109);
INSERT INTO `tbl_role_menu` VALUES (3, 111);
INSERT INTO `tbl_role_menu` VALUES (3, 1000);
INSERT INTO `tbl_role_menu` VALUES (3, 1001);
INSERT INTO `tbl_role_menu` VALUES (3, 1002);
INSERT INTO `tbl_role_menu` VALUES (3, 1003);
INSERT INTO `tbl_role_menu` VALUES (3, 1004);
INSERT INTO `tbl_role_menu` VALUES (3, 1005);
INSERT INTO `tbl_role_menu` VALUES (3, 1006);
INSERT INTO `tbl_role_menu` VALUES (3, 1007);
INSERT INTO `tbl_role_menu` VALUES (3, 1008);
INSERT INTO `tbl_role_menu` VALUES (3, 1009);
INSERT INTO `tbl_role_menu` VALUES (3, 1010);
INSERT INTO `tbl_role_menu` VALUES (3, 1029);
INSERT INTO `tbl_role_menu` VALUES (3, 1030);
INSERT INTO `tbl_role_menu` VALUES (3, 1031);
INSERT INTO `tbl_role_menu` VALUES (4, 1);
INSERT INTO `tbl_role_menu` VALUES (4, 109);
INSERT INTO `tbl_role_menu` VALUES (4, 111);
INSERT INTO `tbl_role_menu` VALUES (4, 1029);
INSERT INTO `tbl_role_menu` VALUES (4, 1030);
INSERT INTO `tbl_role_menu` VALUES (4, 1031);

-- ----------------------------
-- Table structure for tbl_upload
-- ----------------------------
DROP TABLE IF EXISTS `tbl_upload`;
CREATE TABLE `tbl_upload`  (
  `upload_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '即文件ID，为方便识别命名为表名_id',
  `source_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '原文件名',
  `destination_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务器文件名',
  PRIMARY KEY (`upload_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_upload
-- ----------------------------
INSERT INTO `tbl_upload` VALUES (23, '叫了只鸡公告.rar', 'https://enzo-trademark-bucket.oss-cn-beijing.aliyuncs.com/myFile/2020/12/29/1609250967685[I@374cbfe5.rar');

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '盐加密',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES (1, 102, 'admin', '超级管理员', '86521760@qq.com', '18538062907', '0', null, '65e2e098e1d4e793cce6ee6c37055bcb', 'b28182ce-5fd3-4cba-a682-5b5e079af720', '0', '0', '陈建', '2021-06-19 16:43:15', '陈建', '2021-12-09 11:29:45', '测试');
INSERT INTO `tbl_user` VALUES (2, 101, 'normal', '普通管理员', '86521760@qq.com', '15803826759', '1', NULL, '573149142accfa8d251c964bf7bf67ee', '3633e45f-941d-496f-adb7-255f5e2c565b', '0', '0', '陈建', '2021-06-19 16:49:21', '陈建', '2021-06-19 16:54:32', NULL);
INSERT INTO `tbl_user` VALUES (3, 101, 'doudou', '豆豆', '86521760@qq.com', '18538062907', '0', NULL, 'f40821ce93792abc4afa205ecb5e08c9', '21a309f1-aaa3-4720-9ab8-505dfc429745', '0', '0', '潘黎黎', '2021-06-22 11:31:27', '陈建', '2021-07-28 16:28:12', NULL);

-- ----------------------------
-- Table structure for tbl_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_role`;
CREATE TABLE `tbl_user_role`  (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户和角色关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tbl_user_role
-- ----------------------------
INSERT INTO `tbl_user_role` VALUES (1, 1);
INSERT INTO `tbl_user_role` VALUES (2, 1);
INSERT INTO `tbl_user_role` VALUES (3, 2);
INSERT INTO `tbl_user_role` VALUES (4, 2);
INSERT INTO `tbl_user_role` VALUES (5, 1);
INSERT INTO `tbl_user_role` VALUES (5, 2);
INSERT INTO `tbl_user_role` VALUES (6, 1);
INSERT INTO `tbl_user_role` VALUES (7, 1);
INSERT INTO `tbl_user_role` VALUES (7, 2);
INSERT INTO `tbl_user_role` VALUES (8, 1);
INSERT INTO `tbl_user_role` VALUES (8, 2);
INSERT INTO `tbl_user_role` VALUES (9, 1);
INSERT INTO `tbl_user_role` VALUES (9, 2);
INSERT INTO `tbl_user_role` VALUES (10, 1);
INSERT INTO `tbl_user_role` VALUES (10, 2);
INSERT INTO `tbl_user_role` VALUES (10, 3);
INSERT INTO `tbl_user_role` VALUES (11, 1);
INSERT INTO `tbl_user_role` VALUES (11, 2);
INSERT INTO `tbl_user_role` VALUES (11, 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ud` int(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ud`(`ud`) USING BTREE,
  CONSTRAINT `ud` FOREIGN KEY (`ud`) REFERENCES `user_detail` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'aaa', '111', 1);
INSERT INTO `user` VALUES (2, '王龙飞', '111', 1);
INSERT INTO `user` VALUES (4, 'fff', '222', 2);
INSERT INTO `user` VALUES (5, 'abc', 'faa', 3);

-- ----------------------------
-- Table structure for user_detail
-- ----------------------------
DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_detail
-- ----------------------------
INSERT INTO `user_detail` VALUES (1, '河南郑州', '王龙飞');
INSERT INTO `user_detail` VALUES (2, '湖北武汉', '李元浩');
INSERT INTO `user_detail` VALUES (3, '湖南长沙', '宋义进');

SET FOREIGN_KEY_CHECKS = 1;
