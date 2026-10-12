# StudentManagementSystem

Java 面向对象版本 · 学生管理系统 · 控制台实现增删改查

## ✨ 项目介绍

基于 Java 面向对象思想开发。用 `abstract class Person` 抽象出姓名、性别、年龄等共同属性，
由 `Student` 继承并补充学号、成绩。`ArrayUtils` 封装数组查找逻辑，
`StudentView` 负责控制台菜单交互，`Test` 为程序入口。

## 📂 文件结构

```
src/Demo/
├─ Person.java          抽象父类，封装 name/sex/age，abstract display()
├─ Student.java         继承 Person，补充 sid/score，实现 display()
├─ ArrayUtils.java      工具类，静态方法按学号查找索引
├─ StudentView.java     控制台菜单与增删改查逻辑
└─ Test.java            程序入口 main 方法
```

## 💻 开发环境

- JDK 8 及以上
- IDEA

## 📌 功能清单

- 添加学生信息
- 按学号修改学生信息
- 按学号删除学生信息
- 查看全部学生信息（按学号升序排列）

## ⚠️ 已知待改进

- 学号未做重复性校验，重复学号会导致修改/删除只作用于第一个匹配项
- 数组容量固定为 50，超出后会数组越界
- 暂无独立「按学号查找」功能（菜单中未提供）
