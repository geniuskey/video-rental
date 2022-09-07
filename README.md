# 2022년 B4차 6조 재설계 - Video Rental 과제 

## Detected smells
- Long Method
- Large Class
- God Class
- Primitive Obsession
- Switch Statement
- Duplicate Code
- Dead Code
- Shotgun Surgery


## Prioritization of the detected smells
|   Detected Smells   | Prioritization |                                  Comments                                  |
|:-------------------:|:--------------:|:--------------------------------------------------------------------------:|
| Long Method         |       하       | SRP에 준수하여 기능 및 코드 분할                                           |
| Large Class         |       중       | VRUI 클래스를 역할 별로 분리한다.                                          |
| God Class           |       상       | VRUI의 Presentation과 Business logic 분리 필요                             |
| Primitive Obsession |       중       | Video Class 내 PriceCode, Type의 Enum Class 선언                           |
| Switch Statement    |       하       | VRUI Command 별 카테고리화를 통한 case 복잡도 개선 (Customer, Video, Quit) |
| Duplicate Code      |       중       | Video Class내의 멤버 함수로 정의 (SRP 준수)                                |
| Dead Code           |       하       | 향후 사용 가능성이 있어 유지함.                                            |
| Shotgun Surgery     |       상       | 흩어진 변경 기능을 하나의 클래스에 모아서 응집도 높임.                     |

위의 내용은 수정 필요. Ex 5 의 내용을 복사해옴. 
