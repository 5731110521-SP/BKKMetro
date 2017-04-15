# BKKMetro
#### How to change branch :sparkles:
1. ใน GitHub desktop มองมุมซ้ายบน 
2. กดตรง master เลือก branch ที่ต้องการ
3. ถ้าจะสร้างใหม่ก็กดข้างซ้าย

#### How to merge :sparkles:
1. เปิด GitHub desktop จาก branchที่ทำอยู่
2. กด compare branch ที่ต้องการ merge
3. กด Update from 'branch name' ถ้าไม่ error ก็สบาย
4. ถ้าerror ก็ลองดูรงchange สามารถdiscard changeได้บางอัน ดูเองดีๆแล้วกดcommit
5. ถ้าเป็นกรณีแก้ไฟล์เดียวกัน ก็กด commit ไปเลย แล้วมันจะขึ้น error ให้กดใช้ผ่าน command
6. พิมพ์ `git status` ดูบรรทัดที่สีแดง Unmerged paths:
7. พิมพ์ `git add` .. ตามบรรทัดที่สีแดง เช่น สีแดงว่า 
```
Unmerged paths:
  (use "git add <file>..." to mark resolution)
      both added:      .idea/vcs.xml
```

ก็พิมพ์ว่า `git add .idea/vcs.xml`

8. พิมพ์ `git commit` เสร็จ
9. อย่าลืมแก้บางส่วนที่ error เพราะเกิดจากการแก้ไฟล์เดียวกัน มันจะเป็นแบบ
```
<<<<<<< HEAD
  บลาๆ คือโค้ดที่ทำเรา
=======
 บลาๆ คือโค้ดที่ master เคยเป็นอยู่
>>>>>>> refs/remote/origin/master
```

10. ลองแก้ๆไป ...
