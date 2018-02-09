//Maged Mahmoud
//OOP
//EXTRA CREDIT



/*
Put node_start in the OPEN list with f(node_start) = h(node_start) (initialization) while the OPEN list is not empty {
Take from the open list the node node_current with the lowest f (node_current) = g(node_current) + h(node_current)
if node_current is node_goal we have found the solution; break Generate each state node_successor that come after node_current for each node_successor of node_current {
Set successor_current_cost = g(node_current) + w(node_current, node_successor) if node_successor is in the OPEN list {
if g(node_successor) ≤ successor_current_cost continue (to line 20) } else if node_successor is in the CLOSED list {
if g(node_successor) ≤ successor_current_cost continue (to line 20)
Move node_successor from the CLOSED list to the OPEN list } else {
Add node_successor to the OPEN list
Set h(node_successor) to be the heuristic distance to node_goal }
Set g(node_successor) = successor_current_cost
Set the parent of node_successor to node_current }
Add node_current to the CLOSED list }
if(node_current != node_goal) exit with error (the OPEN list is empty)
*/



   public final List<T> findPath(int oldX, int oldY, int newX, int newY) {
        openList = new LinkedList<T>();
        closedList = new LinkedList<T>();
        openList.add(nodes[oldX][oldY]); 

        done = false;
        T current;
        while (!done) {
            current = lowestFInOpen(); // get node with lowest fCosts from openList
            closedList.add(current); // add current node to closed list
            openList.remove(current); // delete current node from open list

            if ((current.getxPosition() == newX)
                    && (current.getyPosition() == newY)) { // found goal
                return calcPath(nodes[oldX][oldY], current);
            }

            // for all successor_ nodes:
            List<T> successor_Nodes = getsuccessor_(current);
            for (int i = 0; i < successor_Nodes.size(); i++) {
                T currentAdj = successor_Nodes.get(i);
                if (!openList.contains(currentAdj)) { // node is not in openList
                    currentAdj.setPrevious(current); // set current node as previous for this node
                    currentAdj.sethCosts(nodes[newX][newY]); // set h costs of this node (estimated costs to goal)
                    currentAdj.setgCosts(current); // set g costs of this node (costs from start to this node)
                    openList.add(currentAdj); // add node to openList
                } else { // node is in openList
                    if (currentAdj.getgCosts() > currentAdj.calculategCosts(current)) { // costs from current node are cheaper than previous costs
                        currentAdj.setPrevious(current); // set current node as previous for this node
                        currentAdj.setgCosts(current); // set g costs of this node (costs from start to this node)
                    }
                }
            }
            if (openList.isEmpty()) { // no path exists
                System.out.println("The open list is empty");
                return new LinkedList<T>(); // return empty list
            }
        }
        return null; // unreachable
    }
