

class FruitGarden:
    def __init__(
            self,
            square:int,
            treeCount:int,
            fruitType:str = ""
    ):
        self.square = square
        self.treeCount = treeCount
        self.fruitType = fruitType
    def increaseTreeCount(self):
        self.treeCount += 1
    def decreaseTreeCount(self):
        self.treeCount -= 1
    def info(self):
        print(self.square, self.treeCount, self.fruitType)

class AppleGarden(FruitGarden):
    def __init__(self, square: int, treeCount: int, fruitType: str = "Apple"):
        super().__init__(square, treeCount, fruitType)
        self.fruitType = fruitType


    def special_info(self):
        print("this is a GardenApple")

class PearGarden(FruitGarden):
    def __init__(self, square: int, treeCount: int, fruitType: str = "Pear"):
        super().__init__(square, treeCount, fruitType)
        self.fruitType = fruitType

    def special_info(self):
        print("this is a GardenPear")