# StudentManagementSystem

Java 面向对象版本 · 学生管理系统 · 控制台实现增删查改

## ✨ 项目介绍

基于 Java 面向对象思想开发。用 `class Person` 抽象出姓名、性别、年龄等共同属性，
由 `Student` 继承并补充学号、成绩，`StudentView` 负责控制台菜单交互，`Test` 为程序入口。
v3.0 起学生数据改用 `HashMap<Integer, Student>` 存储，**以学号作为键**，
查重、查找、修改、删除均通过哈希表直接定位，查找复杂度由 O(n) 降为 O(1)。
查看全部学生时取出 `values()` 转成 `ArrayList`，用 Lambda 表达式按学号升序排序后输出。
v3.1 在此基础上补充了「按学号查询单个学生」功能。
v4.0 接入文件持久化：数据以 CSV 格式存入 `students.txt`，每次增删改后自动保存，
程序启动时自动读取，关闭程序不再丢失数据。

## 📂 文件结构

```
src/Demo/
├─ Person.java          父类，封装 name/sex/age
├─ Student.java         继承 Person，补充 sid/score，重写 toString()
├─ Tool.java            输入工具类，提供 readInt / readSex 的容错读取
├─ StudentStorage.java  数据持久化，负责 students.txt 的读写
├─ StudentView.java     控制台菜单与增删改查逻辑
└─ Test.java            程序入口 main 方法
```

## 💻 开发环境

- JDK 8 及以上
- IDEA

## 📌 功能清单

- 添加学生信息（**学号重复会被拦截**）
- 按学号修改学生信息（学号不存在会提示修改失败）
- 按学号删除学生信息
- 查看全部学生信息（按学号升序排列）
- 按学号查询单个学生信息（v3.1 新增）
- **数据自动持久化**：每次增删改后写入 `students.txt`，重启自动读取（v4.0 新增）
- 所有输入均有容错：菜单、学号、年龄、分数只接受数字，性别只接受「男/女」

## 📝 版本记录

| 版本 | 内容 |
|---|---|
| **v4.0** | 接入文件持久化（`StudentStorage`）：以 CSV 格式读写 `students.txt`，增删改后即时保存、启动时自动加载；新增 `Tool` 工具类统一处理输入容错；异常改为就地处理，全项目不再向外 `throws` |
| v3.1 | 新增「按学号查询」功能（`findAllById`）；方法命名区分 `findAllStudents`（查全部）与 `findAllById`（查单个）；修改/删除的失败提示文案统一 |
| v3.0 | 学生存储由 `ArrayList` 改为 `HashMap<Integer, Student>`，以学号为键，查重/查找/删除均为 O(1)；移除 `ArrayUtils` 工具类；`Person` 去掉抽象方法与 `display()`，统一使用 `toString()` 输出 |
| v2.0 | 修复学号重复添加问题；手写冒泡排序改为 `Arrays.sort` + 实现 `Comparable` |
| v1.5 | 新增 `Person` 抽象类，`Student` 继承并用抽象方法 + 多态实现信息展示；完成 CRUD 基础功能 |
| v1.0 | 面向对象版本基础增删查（定长数组 `Student[50]` + `count` 计数器） |

## ⚠️ 已知待改进

- 数据以 CSV 明文存储于 `students.txt`，无并发保护，多进程同时写入会互相覆盖
- 尚未接入数据库，数据量大时读写整个文件效率偏低
- 排序依赖 Lambda 比较器，尚未让 `Student` 实现 `Comparable` 接口
