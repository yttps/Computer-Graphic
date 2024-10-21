import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D

# กำหนดจุดในสามมิติ
# หน้าบนซ้าย (-x,y,z)
x_top_left = -2
y_top_left = 3
z_top_left = 4

# หน้าบนขวา (x,y,z)
x_top_right = 2
y_top_right = 3
z_top_right = 4

# หน้าล่างซ้าย (-x,-y,z)
x_bottom_left = -2
y_bottom_left = -3
z_bottom_left = 4

# หน้าล่างขวา (x,-y,z)
x_bottom_right = 2
y_bottom_right = -3
z_bottom_right = 4

# หลังบนซ้าย (-x,y,-z)
x_back_top_left = -2
y_back_top_left = 3
z_back_top_left = -4

# หลังบนขวา (x,y,-z)
x_back_top_right = 2
y_back_top_right = 3
z_back_top_right = -4

# หลังล่างซ้าย (-x,-y,-z)
x_back_bottom_left = -2
y_back_bottom_left = -3
z_back_bottom_left = -4

# หลังล่างขวา (x,-y,-z)
x_back_bottom_right = 2
y_back_bottom_right = -3
z_back_bottom_right = -4

# สร้างกราฟสามมิติ
fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')

# วาดหน้าบน
ax.plot([x_top_left, x_top_right], [y_top_left, y_top_right], [z_top_left, z_top_right], color='b')
ax.plot([x_top_left, x_bottom_left], [y_top_left, y_bottom_left], [z_top_left, z_bottom_left], color='b')
ax.plot([x_top_right, x_bottom_right], [y_top_right, y_bottom_right], [z_top_right, z_bottom_right], color='b')
ax.plot([x_bottom_left, x_bottom_right], [y_bottom_left, y_bottom_right], [z_bottom_left, z_bottom_right], color='b')

# วาดหน้าล่าง
ax.plot([x_back_top_left, x_back_top_right], [y_back_top_left, y_back_top_right], [z_back_top_left, z_back_top_right], color='g')
ax.plot([x_back_top_left, x_back_bottom_left], [y_back_top_left, y_back_bottom_left], [z_back_top_left, z_back_bottom_left], color='g')
ax.plot([x_back_top_right, x_back_bottom_right], [y_back_top_right, y_back_bottom_right], [z_back_top_right, z_back_bottom_right], color='g')
ax.plot([x_back_bottom_left, x_back_bottom_right], [y_back_bottom_left, y_back_bottom_right], [z_back_bottom_left, z_back_bottom_right], color='g')

# วาดเส้นต่อหน้าบนและหน้าล่าง
ax.plot([x_top_left, x_back_top_left], [y_top_left, y_back_top_left], [z_top_left, z_back_top_left], color='r')
ax.plot([x_top_right, x_back_top_right], [y_top_right, y_back_top_right], [z_top_right, z_back_top_right], color='r')
ax.plot([x_bottom_left, x_back_bottom_left], [y_bottom_left, y_back_bottom_left], [z_bottom_left, z_back_bottom_left], color='r')
ax.plot([x_bottom_right, x_back_bottom_right], [y_bottom_right, y_back_bottom_right], [z_bottom_right, z_back_bottom_right], color='r')

# กำหนดแกน
ax.set_xlabel('X Label')
ax.set_ylabel('Y Label')
ax.set_zlabel('Z Label')

# แสดงภาพ
plt.show()
