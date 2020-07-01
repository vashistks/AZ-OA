

//FINAL Solution
private static int minDays(int[][] matrix) {
  int[][] newGrid = grid.stream()
          .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
          .toArray(int[][]::new);
	if (matrix == null || matrix.length == 0) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        int days = 0;
        int humanCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    humanCount++;
                } else {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty() && humanCount > 0) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] zombie = queue.poll();
                for (int[] dir : directions) {
                    int newX = zombie[0] + dir[0];
                    int newY = zombie[1] + dir[1];

                    if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length && matrix[newX][newY] == 0) {   // when the new coordinates doesn't exceed the boundaries of the matrix or the new valid coordinate is a human, only then turn that to a zombie
                        matrix[newX][newY] = 1;
                        queue.offer(new int[]{newX, newY});   // now that new coordinate is a zombie, add that to the queue so it can be processed in the next level
                        humanCount--;
                    }
                }
            }
            days++;
        }
        return humanCount == 0 ? days : -1;
}

//second solution

private static int minDays(int rows, int columns, List<List<Integer>> grid) {
  if(grid == null || grid.size() == 0)
    return -1;
  int[][] newGrid = grid.stream()
          .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
          .toArray(int[][]::new);

  if(newGrid.length == 0)
    return -1;

	Queue<int[]> q = new LinkedList<>();
	int target = grid.length * grid[0].length;
	int cnt = 0, res = 0;
  //adding 1s into the queue
	for(int i=0;i<grid.length;i++) {
		for(int j=0;j<grid[0].length;j++) {
			if(grid[i][j] == 1) {
				q.offer(new int[] {i,j});
				cnt++;
			}
		}
	}
	int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  //doing a bfs
	while(!q.isEmpty()) {
		int size = q.size();
		if(cnt == target)
			return res;
		for(int i=0;i<size;i++) {
			int[] cur = q.poll();
			for(int[] dir : dirs) {
				int ni = cur[0] + dir[0];
				int nj = cur[1] + dir[1];
				if(ni >=0 && ni < grid.length && nj >=0 && nj < grid[0].length && grid[ni][nj] == 0) {
					cnt++;
					q.offer(new int[] {ni, nj});
					grid[ni][nj] = 1;
				}
			}
		}
		res++;
	}
	return -1;
}
//to convert to int[][]

//////////////////////

private static final int ZOMBIE = 1;
private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

public int minHours(List<List<Integer>> grid) {
    int people = 0;
    Queue<Point> zombies = new ArrayDeque<>();
    for (int r = 0; r < grid.size(); r++) {
        for (int c = 0; c < grid.get(0).size(); c++) {
            if (grid.get(r).get(c) == ZOMBIE) {
                zombies.add(new Point(r, c));
            } else {
                people++;
            }
        }
    }

    if (people == 0) return 0;

    for (int hours = 1; !zombies.isEmpty(); hours++) {
        for (int sz = zombies.size(); sz > 0; sz--) {
            Point zombie = zombies.poll();

            for (int[] dir : DIRS) {
                int r = zombie.r + dir[0];
                int c = zombie.c + dir[1];

                if (isHuman(grid, r, c)) {
                    people--;
                    if (people == 0) return hours;
                    grid.get(r).set(c, ZOMBIE);
                    zombies.add(new Point(r, c));
                }
            }
        }
    }
    return -1;
}

private boolean isHuman(List<List<Integer>> grid, int r, int c) {
    return r >= 0 && r < grid.size() &&c >= 0 && c < grid.get(0).size() && grid.get(r).get(c) != ZOMBIE;
}

private static class Point {
    int r, c;
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
