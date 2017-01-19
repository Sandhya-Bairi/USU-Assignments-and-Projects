import matplotlib.pyplot as plot

x = [-1, 0, 1, 2, 3, 4, 5, 6, 7]
y = [10, 10, 8, 9, 5, 3, 3, 4, 6]

labels = ["t0", "t1", "t2", "t3", "t4", "t5", "t6", "t7"]

plot.xticks(x, labels)
plot.ylim(ymin=0, ymax=12)
plot.step(x, y)
plot.show()