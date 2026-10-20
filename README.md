# StudentManagementSystem

Java 面向对象版本 · 学生管理系统 · 控制台实现增删查改

## ✨ 项目介绍

基于 Java 面向对象思想开发。用 `class Person` 抽象出姓名、性别、年龄等共同属性，
由 `Student` 继承并补充学号、成绩，`StudentView` 负责控制台菜单交互，`Test` 为程序入口。
v3.0 起学生数据改用 `HashMap<Integer, Student>` 存储，**以学号作为键**，
查重、查找、修改、删除均通过哈希表直接定位，查找复杂度由 O(n) 降为 O(1)。
查看全部学生时取出 `values()` 转成 `ArrayList`，用 Lambda 表达式按学号升序排序后输出。

## 📂 文件结构

```
src/Demo/
├─ Person.java          父类，封装 name/sex/age
├─ Student.java         继承 Person，补充 sid/score，重写 toString()
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

## 📝 版本记录

| 版本 | 内容 |
|---|---|
| **v3.0** | 学生存储由 `ArrayList` 改为 `HashMap<Integer, Student>`，以学号为键，查重/查找/删除均为 O(1)；移除 `ArrayUtils` 工具类；`Person` 去掉抽象方法与 `display()`，统一使用 `toString()` 输出 |
| v2.0 | 修复学号重复添加问题；手写冒泡排序改为 `Arrays.sort` + 实现 `Comparable` |
| v1.5 | 新增 `Person` 抽象类，`Student` 继承并用抽象方法 + 多态实现信息展示；完成 CRUD 基础功能 |
| v1.0 | 面向对象版本基础增删查 |

## ⚠️ 已知待改进

- 数据仅存于内存，程序退出即丢失，尚未接入数据库
- 暂无独立「按学号查找」功能（菜单中未提供，只能查看全部）
- 排序依赖 Lambda 比较器，尚未让 `Student` 实现 `Comparable` 接口
