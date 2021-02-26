import glob
from pathlib import Path
from extract_sepolicy_plat import SEPlatParser

def main():
  files = glob.glob("./lineage_plat/*.te")
  for file in files:
    type = Path(file).stem
    setypeparser = SEPlatParser(type)
    setypeparser.parseFolder("./stock/")
    setypeparser.parseFolder("./lineage/")

if __name__ == '__main__':
    main()
